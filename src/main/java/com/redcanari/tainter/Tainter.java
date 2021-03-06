/*
 * BurpKit - WebKit-based penetration testing plugin for BurpSuite
 * Copyright (C) 2015  Red Canari, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.redcanari.tainter;

import com.redcanari.util.HttpUtils;

import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ndouba on 2014-06-03.
 */
public class Tainter extends ConcurrentHashMap<String, String> {

    private static Integer lastId = -1;
    private static Tainter theTainter = new Tainter();

    protected Tainter() {
    }

    public static Tainter getInstance() {
        return theTainter;
    }

    public synchronized static String nextId() {
        Tainter.lastId++;
        return "tainter-" + Tainter.lastId;
    }

    public String put(String key, URL url) {
        return put(key, HttpUtils.normalizeUrl(url));
    }
}
