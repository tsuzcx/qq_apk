package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class AcsMsg
  extends JceStruct
  implements Comparable<AcsMsg>
{
  public String banner_url = "";
  public String btn_text = "";
  public String busi_icon = "";
  public String busi_id = "";
  public String busi_name = "";
  public String content = "";
  public String flag_text = "";
  public String jump_url = "";
  public String msg_id = "";
  public long notice_time;
  public long sub_time;
  public String title = "";
  public int type;
  
  public AcsMsg() {}
  
  public AcsMsg(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, long paramLong2, String paramString9, String paramString10)
  {
    this.msg_id = paramString1;
    this.busi_id = paramString2;
    this.busi_name = paramString3;
    this.busi_icon = paramString4;
    this.sub_time = paramLong1;
    this.type = paramInt;
    this.flag_text = paramString5;
    this.btn_text = paramString6;
    this.title = paramString7;
    this.content = paramString8;
    this.notice_time = paramLong2;
    this.banner_url = paramString9;
    this.jump_url = paramString10;
  }
  
  public int compareTo(AcsMsg paramAcsMsg)
  {
    int k = 0;
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = JceUtil.compareTo(this.notice_time, paramAcsMsg.notice_time);
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < arrayOfInt.length)
      {
        if (arrayOfInt[i] != 0) {
          j = arrayOfInt[i];
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    label132:
    label156:
    label180:
    label204:
    label228:
    label252:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return bool1;
                                bool1 = bool3;
                              } while (paramObject == null);
                              bool1 = bool3;
                            } while (getClass() != paramObject.getClass());
                            paramObject = (AcsMsg)paramObject;
                            bool1 = bool3;
                          } while (this.sub_time != paramObject.sub_time);
                          bool1 = bool3;
                        } while (this.type != paramObject.type);
                        bool1 = bool3;
                      } while (this.notice_time != paramObject.notice_time);
                      if (this.msg_id == null) {
                        break;
                      }
                      bool1 = bool3;
                    } while (!this.msg_id.equals(paramObject.msg_id));
                    if (this.busi_id == null) {
                      break label330;
                    }
                    bool1 = bool3;
                  } while (!this.busi_id.equals(paramObject.busi_id));
                  if (this.busi_name == null) {
                    break label339;
                  }
                  bool1 = bool3;
                } while (!this.busi_name.equals(paramObject.busi_name));
                if (this.busi_icon == null) {
                  break label348;
                }
                bool1 = bool3;
              } while (!this.busi_icon.equals(paramObject.busi_icon));
              if (this.flag_text == null) {
                break label357;
              }
              bool1 = bool3;
            } while (!this.flag_text.equals(paramObject.flag_text));
            if (this.btn_text == null) {
              break label366;
            }
            bool1 = bool3;
          } while (!this.btn_text.equals(paramObject.btn_text));
          if (this.title == null) {
            break label375;
          }
          bool1 = bool3;
        } while (!this.title.equals(paramObject.title));
        if (this.content == null) {
          break label384;
        }
        bool1 = bool3;
      } while (!this.content.equals(paramObject.content));
      if (this.banner_url == null) {
        break label393;
      }
      bool1 = bool3;
    } while (!this.banner_url.equals(paramObject.banner_url));
    label276:
    label300:
    if (this.jump_url != null) {
      bool1 = this.jump_url.equals(paramObject.jump_url);
    }
    for (;;)
    {
      return bool1;
      if (paramObject.msg_id == null) {
        break;
      }
      return false;
      label330:
      if (paramObject.busi_id == null) {
        break label132;
      }
      return false;
      label339:
      if (paramObject.busi_name == null) {
        break label156;
      }
      return false;
      label348:
      if (paramObject.busi_icon == null) {
        break label180;
      }
      return false;
      label357:
      if (paramObject.flag_text == null) {
        break label204;
      }
      return false;
      label366:
      if (paramObject.btn_text == null) {
        break label228;
      }
      return false;
      label375:
      if (paramObject.title == null) {
        break label252;
      }
      return false;
      label384:
      if (paramObject.content == null) {
        break label276;
      }
      return false;
      label393:
      if (paramObject.banner_url == null) {
        break label300;
      }
      return false;
      bool1 = bool2;
      if (paramObject.jump_url != null) {
        bool1 = false;
      }
    }
  }
  
  public int hashCode()
  {
    int i5 = 0;
    int i;
    int j;
    label33:
    int k;
    label48:
    int m;
    label64:
    int i6;
    int i7;
    int n;
    label101:
    int i1;
    label117:
    int i2;
    label133:
    int i3;
    label149:
    int i8;
    if (this.msg_id != null)
    {
      i = this.msg_id.hashCode();
      if (this.busi_id == null) {
        break label273;
      }
      j = this.busi_id.hashCode();
      if (this.busi_name == null) {
        break label278;
      }
      k = this.busi_name.hashCode();
      if (this.busi_icon == null) {
        break label283;
      }
      m = this.busi_icon.hashCode();
      i6 = (int)(this.sub_time ^ this.sub_time >>> 32);
      i7 = this.type;
      if (this.flag_text == null) {
        break label289;
      }
      n = this.flag_text.hashCode();
      if (this.btn_text == null) {
        break label295;
      }
      i1 = this.btn_text.hashCode();
      if (this.title == null) {
        break label301;
      }
      i2 = this.title.hashCode();
      if (this.content == null) {
        break label307;
      }
      i3 = this.content.hashCode();
      i8 = (int)(this.notice_time ^ this.notice_time >>> 32);
      if (this.banner_url == null) {
        break label313;
      }
    }
    label273:
    label278:
    label283:
    label289:
    label295:
    label301:
    label307:
    label313:
    for (int i4 = this.banner_url.hashCode();; i4 = 0)
    {
      if (this.jump_url != null) {
        i5 = this.jump_url.hashCode();
      }
      return (i4 + ((i3 + (i2 + (i1 + (n + (((m + (k + (j + i * 31) * 31) * 31) * 31 + i6) * 31 + i7) * 31) * 31) * 31) * 31) * 31 + i8) * 31) * 31 + i5;
      i = 0;
      break;
      j = 0;
      break label33;
      k = 0;
      break label48;
      m = 0;
      break label64;
      n = 0;
      break label101;
      i1 = 0;
      break label117;
      i2 = 0;
      break label133;
      i3 = 0;
      break label149;
    }
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.msg_id = paramJceInputStream.readString(0, false);
    this.busi_id = paramJceInputStream.readString(1, false);
    this.busi_name = paramJceInputStream.readString(2, false);
    this.busi_icon = paramJceInputStream.readString(3, false);
    this.sub_time = paramJceInputStream.read(this.sub_time, 4, false);
    this.type = paramJceInputStream.read(this.type, 5, false);
    this.flag_text = paramJceInputStream.readString(6, false);
    this.btn_text = paramJceInputStream.readString(7, false);
    this.title = paramJceInputStream.readString(8, false);
    this.content = paramJceInputStream.readString(9, false);
    this.notice_time = paramJceInputStream.read(this.notice_time, 10, false);
    this.banner_url = paramJceInputStream.readString(11, false);
    this.jump_url = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.msg_id != null) {
      paramJceOutputStream.write(this.msg_id, 0);
    }
    if (this.busi_id != null) {
      paramJceOutputStream.write(this.busi_id, 1);
    }
    if (this.busi_name != null) {
      paramJceOutputStream.write(this.busi_name, 2);
    }
    if (this.busi_icon != null) {
      paramJceOutputStream.write(this.busi_icon, 3);
    }
    paramJceOutputStream.write(this.sub_time, 4);
    paramJceOutputStream.write(this.type, 5);
    if (this.flag_text != null) {
      paramJceOutputStream.write(this.flag_text, 6);
    }
    if (this.btn_text != null) {
      paramJceOutputStream.write(this.btn_text, 7);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 8);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 9);
    }
    paramJceOutputStream.write(this.notice_time, 10);
    if (this.banner_url != null) {
      paramJceOutputStream.write(this.banner_url, 11);
    }
    if (this.jump_url != null) {
      paramJceOutputStream.write(this.jump_url, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.AcsMsg
 * JD-Core Version:    0.7.0.1
 */