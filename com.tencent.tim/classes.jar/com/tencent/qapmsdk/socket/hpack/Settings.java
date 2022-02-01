package com.tencent.qapmsdk.socket.hpack;

import java.util.Arrays;

public final class Settings
{
  static final int COUNT = 10;
  static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
  static final int ENABLE_PUSH = 2;
  static final int HEADER_TABLE_SIZE = 1;
  static final int INITIAL_WINDOW_SIZE = 7;
  static final int MAX_CONCURRENT_STREAMS = 4;
  static final int MAX_FRAME_SIZE = 5;
  static final int MAX_HEADER_LIST_SIZE = 6;
  private int set;
  private final int[] values = new int[10];
  
  void clear()
  {
    this.set = 0;
    Arrays.fill(this.values, 0);
  }
  
  int get(int paramInt)
  {
    return this.values[paramInt];
  }
  
  boolean getEnablePush(boolean paramBoolean)
  {
    int i;
    if ((0x4 & this.set) != 0) {
      i = this.values[2];
    }
    while (i == 1)
    {
      return true;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
    }
    return false;
  }
  
  int getHeaderTableSize()
  {
    if ((0x2 & this.set) != 0) {
      return this.values[1];
    }
    return -1;
  }
  
  int getInitialWindowSize()
  {
    if ((0x80 & this.set) != 0) {
      return this.values[7];
    }
    return 65535;
  }
  
  int getMaxConcurrentStreams(int paramInt)
  {
    if ((0x10 & this.set) != 0) {
      paramInt = this.values[4];
    }
    return paramInt;
  }
  
  int getMaxFrameSize(int paramInt)
  {
    if ((0x20 & this.set) != 0) {
      paramInt = this.values[5];
    }
    return paramInt;
  }
  
  int getMaxHeaderListSize(int paramInt)
  {
    if ((0x40 & this.set) != 0) {
      paramInt = this.values[6];
    }
    return paramInt;
  }
  
  boolean isSet(int paramInt)
  {
    return (1 << paramInt & this.set) != 0;
  }
  
  void merge(Settings paramSettings)
  {
    int i = 0;
    if (i < 10)
    {
      if (!paramSettings.isSet(i)) {}
      for (;;)
      {
        i += 1;
        break;
        set(i, paramSettings.get(i));
      }
    }
  }
  
  Settings set(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.values.length)) {
      return this;
    }
    this.set = (1 << paramInt1 | this.set);
    this.values[paramInt1] = paramInt2;
    return this;
  }
  
  int size()
  {
    return Integer.bitCount(this.set);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.hpack.Settings
 * JD-Core Version:    0.7.0.1
 */