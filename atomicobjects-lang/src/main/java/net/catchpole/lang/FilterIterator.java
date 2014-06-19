package net.catchpole.lang;

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

import java.util.Iterator;

public abstract class FilterIterator<T> implements Iterator<T> {
    private final Iterator<T> iterator;
    private T next;
    private boolean loaded = false;
    private boolean hasNext;

    public FilterIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    public boolean hasNext() {
        loadIfNeeded();
        return hasNext;
    }

    public T next() {
        loadIfNeeded();
        loaded = false;
        if (!hasNext) {
            throw new IllegalStateException();
        }
        return next;
    }

    public void remove() {
        this.iterator.remove();
    }

    private void loadIfNeeded() {
        if (!this.loaded) {
            this.loaded = true;
            while (this.iterator.hasNext()) {
                T type = this.iterator.next();
                if (include(type)) {
                    this.next = type;
                    this.hasNext = true;
                    return;
                }
            }
            this.hasNext = false;
        }
    }

    public abstract boolean include(T type);
}
