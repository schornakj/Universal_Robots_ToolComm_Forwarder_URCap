// -- BEGIN LICENSE BLOCK ----------------------------------------------
// Copyright 2019 FZI Forschungszentrum Informatik
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// -- END LICENSE BLOCK ------------------------------------------------

//----------------------------------------------------------------------
/*!\file
 *
 * \author  Lea Steffen steffen@fzi.de
 * \date    2019-05-13
 *
 */
//----------------------------------------------------------------------
package com.fzi.rs485.impl;
import com.ur.urcap.api.contribution.DaemonContribution;
import com.ur.urcap.api.contribution.DaemonService;

import java.net.MalformedURLException;
import java.net.URL;

public class RS485DaemonService implements DaemonService {
  private DaemonContribution daemonContribution;

  public RS485DaemonService() {}

  @Override
  public void init(DaemonContribution daemonContribution) {
    this.daemonContribution = daemonContribution;
    try {
      daemonContribution.installResource(new URL("file:com/fzi/rs485/impl/daemon/"));
    } catch (MalformedURLException e) {
    }
  }

  @Override
  public URL getExecutable() {
    try {
      return new URL("file:com/fzi/rs485/impl/daemon/daemon-rs485.py"); // Python executable
      // return new URL("file:com/fzi/rs485/impl/daemon/rs.py"); // Python executable
    } catch (MalformedURLException e) {
      return null;
    }
  }

  public DaemonContribution getDaemon() {
    return daemonContribution;
  }
}
