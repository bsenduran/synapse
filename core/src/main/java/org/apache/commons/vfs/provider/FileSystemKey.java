/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.vfs.provider;

import org.apache.commons.vfs.FileSystemOptions;

/**
 * Used to identify a filesystem
 *
 * @author <a href="mailto:imario@apache.org">Mario Ivankovits</a>
 * @version $Revision: 804548 $ $Date: 2009-08-16 07:42:32 +0530 (Sun, 16 Aug 2009) $
 */
class FileSystemKey implements Comparable
{
    private static final FileSystemOptions EMPTY_OPTIONS = new FileSystemOptions();

    private final Comparable key;
    private final FileSystemOptions fileSystemOptions;

    FileSystemKey(final Comparable key, final FileSystemOptions fileSystemOptions)
    {
        this.key = key;
        if (fileSystemOptions != null)
        {
            this.fileSystemOptions = fileSystemOptions;
        }
        else
        {
            this.fileSystemOptions = EMPTY_OPTIONS;
        }
    }

    public int compareTo(Object o)
    {
        FileSystemKey fk = (FileSystemKey) o;

        int ret = key.compareTo(fk.key);
        if (ret != 0)
        {
            // other filesystem
            return ret;
        }

        return fileSystemOptions.compareTo(fk.fileSystemOptions);
    }
}