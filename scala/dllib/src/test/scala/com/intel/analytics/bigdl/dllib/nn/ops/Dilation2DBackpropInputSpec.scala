/*
 * Copyright 2016 The BigDL Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intel.analytics.bigdl.dllib.nn.ops

import com.intel.analytics.bigdl.dllib.tensor.Tensor
import com.intel.analytics.bigdl.dllib.utils.T
import com.intel.analytics.bigdl.dllib.utils.serializer.ModuleSerializationTest


class Dilation2DBackpropInputSerialTest extends ModuleSerializationTest {
  override def test(): Unit = {
    val module = Dilation2DBackpropInput[Float, Float](
      Array(1, 3, 2, 1), Array(1, 2, 3, 1), "same")

    val input = T(Tensor[Float](4, 32, 32, 3).rand(),
      Tensor[Float](3, 4, 3).rand(),
      Tensor[Float](4, 11, 16, 3).rand())

    runSerializationTest(module, input)
  }
}
