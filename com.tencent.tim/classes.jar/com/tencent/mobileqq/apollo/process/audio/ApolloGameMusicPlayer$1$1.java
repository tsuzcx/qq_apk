package com.tencent.mobileqq.apollo.process.audio;

import abmz;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;

public class ApolloGameMusicPlayer$1$1
  extends IApolloRunnableTask
{
  public ApolloGameMusicPlayer$1$1(abmz paramabmz, ApolloSurfaceView paramApolloSurfaceView) {}
  
  public String aV()
  {
    return "mediaPlayer_onCompletion";
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Abmz.ND != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().getSavaWrapper().gP(this.jdField_a_of_type_Abmz.ND);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.audio.ApolloGameMusicPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */