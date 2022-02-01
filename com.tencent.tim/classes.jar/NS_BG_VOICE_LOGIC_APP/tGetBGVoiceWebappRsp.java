package NS_BG_VOICE_LOGIC_APP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class tGetBGVoiceWebappRsp
  extends JceStruct
{
  static BGVoice cache_stBGVoice = new BGVoice();
  public int iRet;
  public byte loop_playback_flag;
  public byte play_mode_flag;
  public BGVoice stBGVoice;
  public String strErrMsg = "";
  public byte wifi_auto_play;
  
  public tGetBGVoiceWebappRsp() {}
  
  public tGetBGVoiceWebappRsp(int paramInt, String paramString, BGVoice paramBGVoice, byte paramByte1, byte paramByte2, byte paramByte3)
  {
    this.iRet = paramInt;
    this.strErrMsg = paramString;
    this.stBGVoice = paramBGVoice;
    this.wifi_auto_play = paramByte1;
    this.play_mode_flag = paramByte2;
    this.loop_playback_flag = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, false);
    this.strErrMsg = paramJceInputStream.readString(1, false);
    this.stBGVoice = ((BGVoice)paramJceInputStream.read(cache_stBGVoice, 2, false));
    this.wifi_auto_play = paramJceInputStream.read(this.wifi_auto_play, 3, false);
    this.play_mode_flag = paramJceInputStream.read(this.play_mode_flag, 4, false);
    this.loop_playback_flag = paramJceInputStream.read(this.loop_playback_flag, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    if (this.strErrMsg != null) {
      paramJceOutputStream.write(this.strErrMsg, 1);
    }
    if (this.stBGVoice != null) {
      paramJceOutputStream.write(this.stBGVoice, 2);
    }
    paramJceOutputStream.write(this.wifi_auto_play, 3);
    paramJceOutputStream.write(this.play_mode_flag, 4);
    paramJceOutputStream.write(this.loop_playback_flag, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_BG_VOICE_LOGIC_APP.tGetBGVoiceWebappRsp
 * JD-Core Version:    0.7.0.1
 */