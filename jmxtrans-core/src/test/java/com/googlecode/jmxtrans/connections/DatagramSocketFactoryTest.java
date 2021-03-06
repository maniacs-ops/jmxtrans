/**
 * The MIT License
 * Copyright © 2010 JmxTrans team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.googlecode.jmxtrans.connections;

import com.googlecode.jmxtrans.test.RequiresIO;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetSocketAddress;

import static org.assertj.core.api.Assertions.assertThat;

@Category(RequiresIO.class)
public class DatagramSocketFactoryTest {

	public static final int PORT = 50123;

	@Test
	public void testDatagramSocketFactoryMakeObject() throws Exception {

		DatagramSocketFactory socketFactory = new DatagramSocketFactory();

		InetSocketAddress socketAddress = new InetSocketAddress(Inet4Address.getLocalHost(), PORT);

		DatagramSocket socketObject = socketFactory.makeObject(socketAddress);

		// Test if the remote address/port is the correct one.
		assertThat(socketObject.getPort()).isEqualTo(PORT);
		assertThat(socketObject.getInetAddress()).isEqualTo(Inet4Address.getLocalHost());
	}
}
