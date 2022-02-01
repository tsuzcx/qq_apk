import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import org.json.JSONException;
import org.json.JSONObject;

public class aydc
  extends aygy
  implements Handler.Callback, View.OnClickListener
{
  private ImageView IM;
  private psr a;
  private TextView ahS;
  private boolean dyE;
  private boolean dyF;
  private boolean dyG;
  private boolean dyH;
  private PressDarkImageButton e;
  private boolean enable;
  private int mCurType;
  private Handler mHandler;
  private boolean mIsVideo;
  
  public aydc(@NonNull aygz paramaygz, int paramInt, boolean paramBoolean)
  {
    super(paramaygz);
    this.mCurType = paramInt;
    this.mIsVideo = paramBoolean;
    this.a = ((psr)psx.a(10));
  }
  
  private boolean aQr()
  {
    if ((this.mIsVideo) && (this.dyH)) {}
    while ((!this.mIsVideo) && (this.dyG)) {
      return true;
    }
    return false;
  }
  
  private void aeZ(int paramInt)
  {
    boolean bool2 = true;
    int i = lV(paramInt);
    if ((i & 0x20) > 0)
    {
      bool1 = true;
      this.dyG = bool1;
      if ((i & 0x10) <= 0) {
        break label97;
      }
      bool1 = true;
      label32:
      this.dyH = bool1;
      if ((i & 0x8) <= 0) {
        break label102;
      }
      bool1 = true;
      label46:
      this.dyE = bool1;
      if ((i & 0x4) <= 0) {
        break label107;
      }
      bool1 = true;
      label59:
      this.dyF = bool1;
      if ((i & 0x1) <= 0) {
        break label112;
      }
    }
    label97:
    label102:
    label107:
    label112:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((!this.dyF) && (paramInt != 0)) {
        break label117;
      }
      this.enable = this.dyE;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label32;
      bool1 = false;
      break label46;
      bool1 = false;
      break label59;
    }
    label117:
    if ((i & 0x2) > 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.enable = bool1;
      return;
    }
  }
  
  private static int b(JSONObject paramJSONObject, int paramInt)
    throws JSONException
  {
    int i;
    if (paramJSONObject == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      i = paramInt & 0x3;
      int k = paramJSONObject.optInt("initOpen");
      j = paramJSONObject.optInt("reset");
      int n = paramJSONObject.optInt("sync_pic");
      int m = paramJSONObject.optInt("sync_video");
      paramInt = i;
      if (n == 1) {
        paramInt = i + 32;
      }
      i = paramInt;
      if (m == 1) {
        i = paramInt + 16;
      }
      paramInt = i;
      if (k == 1) {
        paramInt = i + 8;
      }
      i = paramInt;
    } while (j != 1);
    return paramInt + 4;
  }
  
  public static void bj(@NonNull String paramString)
    throws JSONException
  {
    ram.w("Q.qqstory.sync.EditAioSyncToStoryPart", "parseConfig=" + paramString);
    psr localpsr = (psr)psx.a(10);
    int j = ((Integer)localpsr.c("integer_aio_sync_to_story_config_c2c", Integer.valueOf(0))).intValue();
    int k = ((Integer)localpsr.c("integer_aio_sync_to_story_config_group", Integer.valueOf(0))).intValue();
    int i = ((Integer)localpsr.c("integer_aio_sync_to_story_config_discuss", Integer.valueOf(0))).intValue();
    paramString = new JSONObject(paramString);
    j = b(paramString.optJSONObject("other"), j);
    k = b(paramString.optJSONObject("group"), k);
    i = b(paramString.optJSONObject("discuss"), i);
    ram.a("Q.qqstory.sync.EditAioSyncToStoryPart", "handledAIOSyncToStory parse data: c2c=%d,group=%d,discuss=%d", Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i));
    localpsr.n("integer_aio_sync_to_story_config_c2c", Integer.valueOf(j));
    localpsr.n("integer_aio_sync_to_story_config_group", Integer.valueOf(k));
    localpsr.n("integer_aio_sync_to_story_config_discuss", Integer.valueOf(i));
  }
  
  public static void clearConfig()
  {
    ram.w("Q.qqstory.sync.EditAioSyncToStoryPart", "---clearConfig----");
    psr localpsr = (psr)psx.a(10);
    localpsr.n("integer_aio_sync_to_story_config_c2c", Integer.valueOf(0));
    localpsr.n("integer_aio_sync_to_story_config_group", Integer.valueOf(0));
    localpsr.n("integer_aio_sync_to_story_config_discuss", Integer.valueOf(0));
  }
  
  private void eQI()
  {
    if (((Integer)this.a.c("integer_aio_sync_to_story_switcher_guide", Integer.valueOf(0))).intValue() == 0)
    {
      this.a.n("integer_aio_sync_to_story_switcher_guide", Integer.valueOf(1));
      this.ahS.setVisibility(0);
      this.IM.setVisibility(0);
      this.ahS.setOnClickListener(this);
      this.mHandler.sendEmptyMessageDelayed(1, 5000L);
      String str1;
      if (this.mCurType == 1)
      {
        str1 = "3";
        if (!this.mIsVideo) {
          break label141;
        }
      }
      label141:
      for (String str2 = "1";; str2 = "2")
      {
        rar.a("aio_shoot", "exp_tip", 0, 0, new String[] { str1, "", str2 });
        return;
        if (this.mCurType == 3000)
        {
          str1 = "2";
          break;
        }
        str1 = "1";
        break;
      }
    }
    this.ahS.setVisibility(8);
    this.IM.setVisibility(8);
  }
  
  private int lV(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      i = ((Integer)this.a.c("integer_aio_sync_to_story_config_c2c", Integer.valueOf(0))).intValue();
    }
    for (;;)
    {
      ram.w("Q.qqstory.sync.EditAioSyncToStoryPart", "get " + paramInt + " type config=" + i);
      return i;
      i = ((Integer)this.a.c("integer_aio_sync_to_story_config_group", Integer.valueOf(0))).intValue();
      continue;
      i = ((Integer)this.a.c("integer_aio_sync_to_story_config_discuss", Integer.valueOf(0))).intValue();
    }
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    paramayqb.aID = this.enable;
    String str1;
    if (this.mCurType == 1)
    {
      paramayqb = "3";
      if (!this.enable) {
        break label95;
      }
      str1 = "2";
      label35:
      if (!this.mIsVideo) {
        break label101;
      }
    }
    label95:
    label101:
    for (String str2 = "1";; str2 = "2")
    {
      rar.a("aio_shoot", "clk_send", 0, 0, new String[] { paramayqb, str1, str2 });
      return;
      if (this.mCurType == 3000)
      {
        paramayqb = "2";
        break;
      }
      paramayqb = "1";
      break;
      str1 = "1";
      break label35;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.ahS.setVisibility(8);
      this.IM.setVisibility(8);
    }
  }
  
  public void oT(boolean paramBoolean)
  {
    int j = 0;
    if (this.dyG) {
      j = 32;
    }
    int i = j;
    if (this.dyH) {
      i = j + 16;
    }
    j = i;
    if (this.dyE) {
      j = i + 8;
    }
    i = j;
    if (this.dyF) {
      i = j + 4;
    }
    j = i;
    if (paramBoolean) {
      j = i + 2;
    }
    i = j + 1;
    ram.b("Q.qqstory.sync.EditAioSyncToStoryPart", "save config = %s", Integer.valueOf(i));
    switch (this.mCurType)
    {
    default: 
      this.a.n("integer_aio_sync_to_story_config_c2c", Integer.valueOf(i));
      return;
    case 1: 
      this.a.n("integer_aio_sync_to_story_config_group", Integer.valueOf(i));
      return;
    }
    this.a.n("integer_aio_sync_to_story_config_discuss", Integer.valueOf(i));
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    if (paramView == this.e)
    {
      axxe.a(paramView, 200L, new aydd(this));
      oT(this.enable);
      this.ahS.setVisibility(8);
      this.IM.setVisibility(8);
      this.mHandler.removeMessages(1);
      i = j;
      if (this.b.a.asi != 2)
      {
        i = j;
        if (this.b.a.asi != 5) {
          if (this.b.a.asi != 6) {
            break label168;
          }
        }
      }
    }
    label168:
    for (int i = j;; i = 0)
    {
      rar.a("video_edit_aio", "hyws_clk", 0, i, new String[0]);
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (paramView == this.ahS)
        {
          this.ahS.setVisibility(8);
          this.IM.setVisibility(8);
          this.mHandler.removeMessages(1);
        }
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    aeZ(this.mCurType);
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.e = ((PressDarkImageButton)y(2131380035));
    this.IM = ((ImageView)y(2131379075));
    this.ahS = ((TextView)y(2131379076));
    if (!aQr())
    {
      this.e.setVisibility(8);
      this.enable = false;
      return;
    }
    this.e.setVisibility(0);
    this.e.setOnClickListener(this);
    String str1;
    if (this.enable)
    {
      this.e.setChecked(true);
      if (this.mCurType != 1) {
        break label186;
      }
      str1 = "3";
      label133:
      if (!this.mIsVideo) {
        break label208;
      }
    }
    label186:
    label208:
    for (String str2 = "1";; str2 = "2")
    {
      rar.a("aio_shoot", "exp_sync", 0, 0, new String[] { str1, "", str2 });
      eQI();
      return;
      this.e.setChecked(false);
      break;
      if (this.mCurType == 3000)
      {
        str1 = "2";
        break label133;
      }
      str1 = "1";
      break label133;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mHandler.removeMessages(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aydc
 * JD-Core Version:    0.7.0.1
 */