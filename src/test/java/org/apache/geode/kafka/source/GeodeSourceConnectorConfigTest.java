/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.geode.kafka.source;

import static org.apache.geode.kafka.utils.GeodeConfigurationConstants.LOCATORS;
import static org.apache.geode.kafka.utils.GeodeConfigurationConstants.TASK_ID;
import static org.apache.geode.kafka.utils.GeodeSourceConfigurationConstants.DURABLE_CLIENT_ID_PREFIX;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class GeodeSourceConnectorConfigTest {

  @Test
  public void durableClientIdShouldNotBeSetIfPrefixIsEmpty() {
    Map<String, String> props = new HashMap<>();
    props.put(TASK_ID, "0");
    props.put(DURABLE_CLIENT_ID_PREFIX, "");
    props.put(LOCATORS, "localhost[10334]");
    GeodeSourceConnectorConfig config = new GeodeSourceConnectorConfig(props);
    assertEquals("", config.getDurableClientId());
  }

}
