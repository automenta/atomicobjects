package net.catchpole.fuse.signature;

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

import net.catchpole.fuse.annotation.Fuse;
import net.catchpole.fuse.annotation.Transform;
import net.catchpole.image.RenderedImageWriter;

import java.awt.image.RenderedImage;
import java.io.IOException;

@Fuse(classname = "net.catchpole.image.RenderedImageWriter")
public abstract class RenderedImageWriterSignature extends RenderedImageWriter {
    @Transform
    public abstract byte[] write(RenderedImage image) throws IOException;
}
