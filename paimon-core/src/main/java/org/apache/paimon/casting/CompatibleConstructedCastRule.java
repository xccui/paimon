/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.paimon.casting;

import org.apache.paimon.types.DataType;
import org.apache.paimon.types.DataTypeFamily;

/** A cast rule that don't do any cast. */
public class CompatibleConstructedCastRule extends AbstractCastRule<Object, Object> {
    static final CompatibleConstructedCastRule INSTANCE = new CompatibleConstructedCastRule();

    protected CompatibleConstructedCastRule() {
        super(
                CastRulePredicate.builder()
                        .input(DataTypeFamily.CONSTRUCTED)
                        .target(DataTypeFamily.CONSTRUCTED)
                        .build());
    }

    @Override
    public CastExecutor<Object, Object> create(DataType inputType, DataType targetType) {
        return row -> row;
    }
}
