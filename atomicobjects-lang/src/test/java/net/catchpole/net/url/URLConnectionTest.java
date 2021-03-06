package net.catchpole.net.url;

//   Copyright 2014 catchpole.net
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {
    @Test
    public void testAtomURLConnection() throws Exception {
        URL url = new URL(null, "catchpole://local/net/catchpole/util/StringUtils.class",
                new DynamicURLStreamHandler("local", new File("./classes")));

        URLConnection urlConnection = url.openConnection();
        //assertEquals("", urlConnection.getContent());
    }
}
