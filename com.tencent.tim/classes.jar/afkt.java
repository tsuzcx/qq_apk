import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo.QQEmoConfigItem;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afkt
  extends QQSysAndEmojiResInfo
  implements afkw.a
{
  private int cRK;
  
  public int Da()
  {
    return this.cRK;
  }
  
  public void Mz(int paramInt)
  {
    i(getDrawable(paramInt), paramInt);
  }
  
  public void cZW()
  {
    Object localObject1 = Z();
    if (localObject1 != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("emoji");
      if (localJSONArray != null)
      {
        if (this.kn == null) {
          this.kn = new HashMap();
        }
        if (this.wi == null) {
          this.wi = new ArrayList();
        }
        if (this.ko == null) {
          this.ko = new HashMap();
        }
        if (this.kp == null) {
          this.kp = new HashMap();
        }
        if (this.kq == null) {
          this.kq = new HashMap();
        }
        this.kn.clear();
        this.wi.clear();
        this.ko.clear();
        this.kp.clear();
        this.kq.clear();
        long l = System.currentTimeMillis();
        int i = 0;
        for (;;)
        {
          if (i >= localJSONArray.length()) {
            break label394;
          }
          localObject1 = null;
          try
          {
            localObject2 = localJSONArray.getJSONObject(i);
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Object localObject2;
              localJSONException.printStackTrace();
            }
          }
          localObject1 = (QQSysAndEmojiResInfo.QQEmoConfigItem)aiio.convertFromJSONObject((JSONObject)localObject1, QQSysAndEmojiResInfo.QQEmoConfigItem.class);
          try
          {
            int j = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).AQLid);
            int k = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).QCid);
            if (!TextUtils.isEmpty(((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).EMCode))
            {
              localObject2 = "[em]e" + ((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).EMCode + "[/em]";
              String str = ((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).QDes;
              this.kp.put(str, localObject2);
              this.kq.put(localObject2, Integer.valueOf(j));
            }
            this.kn.put(Integer.valueOf(j), localObject1);
            this.ko.put(Integer.valueOf(k), Integer.valueOf(j));
            if (!a((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1)) {
              this.wi.add(Integer.valueOf(j));
            }
            if (j > this.cRK) {
              this.cRK = j;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              QLog.d("QQEmojiResInfo", 1, new Object[] { "error occur in emoji AQLid:", ((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).AQLid });
            }
          }
          i += 1;
        }
        label394:
        if (QLog.isColorLevel()) {
          QLog.d("QQEmojiResInfo", 2, new Object[] { "emoji configItem:", Integer.valueOf(this.kn.size()), " ,orderlist:", Integer.valueOf(this.wi.size()), ", maxLid:", Integer.valueOf(this.cRK), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
    }
  }
  
  public void cZX()
  {
    this.a = new afkw(this);
  }
  
  public void cZY() {}
  
  public String dY(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (this.kn != null)
    {
      str1 = str2;
      if (this.kn.containsKey(Integer.valueOf(paramInt))) {
        str1 = ((QQSysAndEmojiResInfo.QQEmoConfigItem)this.kn.get(Integer.valueOf(paramInt))).QDes;
      }
    }
    return str1;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    for (;;)
    {
      try
      {
        localURL1 = new URL("qqsys_emoji", "host_emoji", String.format("emoji_%03d.png", new Object[] { Integer.valueOf(paramInt) }));
        localURL2 = localURL1;
        localURL2 = localURL1;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("QQEmojiResInfo", 2, "getDrawable url:" + localURL1.toString());
            localURL2 = localURL1;
          }
          return a(localURL2, null, false, String.valueOf(paramInt));
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          URL localURL1;
          URL localURL2;
          break label82;
        }
        localMalformedURLException1 = localMalformedURLException1;
        localURL1 = null;
      }
      label82:
      if (QLog.isColorLevel())
      {
        QLog.d("QQEmojiResInfo", 2, "getDrawable ,", localMalformedURLException1);
        localURL2 = localURL1;
      }
    }
  }
  
  public void hL(int paramInt1, int paramInt2)
  {
    anot.a(null, "dc00898", "", "", "0X800A7A3", "0X800A7A3", hh(paramInt1), 0, String.valueOf(paramInt2), "", "", "");
  }
  
  public int hh(int paramInt)
  {
    int j = -1;
    int i = j;
    if (this.kn != null)
    {
      i = j;
      if (this.kn.containsKey(Integer.valueOf(paramInt))) {
        i = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.kn.get(Integer.valueOf(paramInt))).QCid);
      }
    }
    return i;
  }
  
  public boolean jk(int paramInt)
  {
    boolean bool = false;
    String str = afkv.B(3, String.format("/emoji_%03d.png", new Object[] { Integer.valueOf(paramInt) }));
    if (!TextUtils.isEmpty(str)) {
      bool = new File(str).exists();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkt
 * JD-Core Version:    0.7.0.1
 */