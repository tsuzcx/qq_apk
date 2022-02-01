package cooperation.liveroom;

public abstract interface LiveRoomGiftCallback
{
  public static final int TYPE_ON_CREATE = 0;
  public static final int TYPE_ON_DESTROY = 6;
  public static final int TYPE_ON_ERROR = 2;
  public static final int TYPE_ON_PAUSE = 3;
  public static final int TYPE_ON_PLAYING = 5;
  public static final int TYPE_ON_PLAY_END = 7;
  public static final int TYPE_ON_READY = 1;
  public static final int TYPE_ON_START_PLAY = 4;
  public static final int TYPE_ON_TEXTURE_DESTROYED = 9;
  public static final int TYPE_ON_VISIBILITY_CHANGE = 8;
  
  public abstract void onCall(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomGiftCallback
 * JD-Core Version:    0.7.0.1
 */