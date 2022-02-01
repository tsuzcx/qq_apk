package com.tencent.mobileqq.apollo.game;

import android.os.Process;
import aqgz;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameStateMachine$1
  implements Runnable
{
  ApolloGameStateMachine$1(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    ApolloGameStateMachine.a locala2 = ApolloGameStateMachine.a;
    ApolloGameStateMachine.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new ApolloGameStateMachine.a();
    }
    locala1.NP = aqgz.L(Process.myPid());
    locala1.NQ = aqgz.hH();
    ApolloGameStateMachine.a = locala1;
    ApolloGameStateMachine.cm.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.1
 * JD-Core Version:    0.7.0.1
 */