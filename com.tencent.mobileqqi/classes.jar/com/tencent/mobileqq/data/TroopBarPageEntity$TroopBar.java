package com.tencent.mobileqq.data;

import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;

public class TroopBarPageEntity$TroopBar
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_COVER = "cover";
  protected static final String JSON_KEY_CREATE_TIME = "create_time";
  protected static final String JSON_KEY_ERRNO = "errno";
  protected static final String JSON_KEY_FANS = "fans";
  protected static final String JSON_KEY_INTRO = "intro";
  protected static final String JSON_KEY_PIC = "pic";
  protected static final String JSON_KEY_PIDS = "pids";
  protected static final String JSON_KEY_RECOMMEND_PIDS = "recommend_pids";
  protected static final String JSON_KEY_TODAY_PIDS = "today_pids";
  protected static final long serialVersionUID = 10004L;
  public String cover;
  public long create_time;
  public int errno;
  public int fans;
  public String intro;
  public String pic;
  public int pids;
  public String recommend_pids;
  public int today_pids;
  
  public TroopBarPageEntity$TroopBar() {}
  
  public TroopBarPageEntity$TroopBar(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.cover = TroopBarUtils.a(paramJSONObject, "cover");
    this.errno = TroopBarUtils.a(paramJSONObject, "errno");
    this.pids = TroopBarUtils.a(paramJSONObject, "pids");
    this.fans = TroopBarUtils.a(paramJSONObject, "fans");
    this.today_pids = TroopBarUtils.a(paramJSONObject, "today_pids");
    this.create_time = TroopBarUtils.a(paramJSONObject, "create_time");
    this.pic = TroopBarUtils.a(paramJSONObject, "pic");
    this.recommend_pids = TroopBarUtils.a(paramJSONObject, "recommend_pids");
    this.intro = TroopBarUtils.a(paramJSONObject, "intro");
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.cover = paramObjectInput.readUTF();
    this.errno = paramObjectInput.readInt();
    this.pids = paramObjectInput.readInt();
    this.fans = paramObjectInput.readInt();
    this.today_pids = paramObjectInput.readInt();
    this.create_time = paramObjectInput.readLong();
    this.pic = paramObjectInput.readUTF();
    this.recommend_pids = paramObjectInput.readUTF();
    this.intro = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.cover);
    paramObjectOutput.writeInt(this.errno);
    paramObjectOutput.writeInt(this.pids);
    paramObjectOutput.writeInt(this.fans);
    paramObjectOutput.writeInt(this.today_pids);
    paramObjectOutput.writeLong(this.create_time);
    paramObjectOutput.writeUTF(this.pic);
    paramObjectOutput.writeUTF(this.recommend_pids);
    paramObjectOutput.writeUTF(this.intro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarPageEntity.TroopBar
 * JD-Core Version:    0.7.0.1
 */