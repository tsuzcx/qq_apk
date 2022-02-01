package com.tencent.tavkit.composition.builder;

import java.util.HashMap;
import java.util.List;

class AudioParamsInfo
{
  List<AudioInfo> audioInfos;
  HashMap<String, AudioTransitionInfo> transitionMap;
  
  AudioParamsInfo(List<AudioInfo> paramList, HashMap<String, AudioTransitionInfo> paramHashMap)
  {
    this.audioInfos = paramList;
    this.transitionMap = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.AudioParamsInfo
 * JD-Core Version:    0.7.0.1
 */