import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class lso
  extends ViewBase
{
  private NativeVideoView a;
  private int aPD;
  private int aPE;
  private String aeI;
  private String aft;
  private String mCoverUrl;
  private String mVid;
  private String mVideoUrl;
  
  public lso(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeVideoView(paramVafContext.getContext());
  }
  
  public NativeVideoView a()
  {
    return this.a;
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.a.setBackgroundColor(this.mBackground);
    this.a.setCoverUrl(this.mCoverUrl);
    this.a.setPlayIconUrl(this.aeI);
    this.a.setVideoVid(this.mVid);
    this.a.setPlayIconSize(this.aPD, this.aPE);
    if (!TextUtils.isEmpty(this.mVideoUrl)) {
      this.a.setVideoUrl(this.mVideoUrl);
    }
    try
    {
      this.a.setVideoBusiType(Integer.parseInt(this.aft));
      refresh();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyVideoView", 2, localNumberFormatException.getMessage());
      }
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    String str;
    switch (paramInt)
    {
    case 1142: 
    case 1143: 
    case 1145: 
    default: 
      return super.setAttribute(paramInt, paramObject);
    case 1141: 
      if (((paramObject instanceof JSONArray)) && (((JSONArray)paramObject).length() == 2))
      {
        str = ((JSONArray)paramObject).optString(0);
        paramObject = ((JSONArray)paramObject).optString(1);
      }
      try
      {
        paramInt = Integer.parseInt(str);
        int i = Integer.parseInt(paramObject);
        this.aPD = paramInt;
        this.aPE = i;
        return true;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          paramObject.printStackTrace();
        }
      }
    case 1144: 
      if (((paramObject instanceof JSONArray)) && (((JSONArray)paramObject).length() == 2)) {
        try
        {
          str = ((JSONArray)paramObject).optString(0);
          paramObject = ((JSONArray)paramObject).optString(1);
          this.mVid = str;
          this.aft = paramObject;
          return true;
        }
        catch (NumberFormatException paramObject)
        {
          paramObject.printStackTrace();
          return false;
        }
      }
      break;
    }
    if ((paramObject instanceof JSONObject)) {
      try
      {
        this.a.setReportR5(paramObject.toString());
        return true;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.d("ReadInJoyVideoView", 1, paramObject.getMessage());
        }
      }
    }
    return false;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 1141: 
    case 1144: 
    case 1146: 
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1137: 
      this.mVid = paramString;
      return true;
    case 1135: 
      this.mVideoUrl = paramString;
      return true;
    case 1136: 
      this.mCoverUrl = paramString;
      return true;
    case 1138: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.setLoop("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1139: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.setMute("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1140: 
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.a.setScaleType(Integer.parseInt(paramString));
          return true;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
          return false;
        }
      }
      return false;
    case 1142: 
      this.aeI = paramString;
      return true;
    case 1143: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.setPlayIconVisible("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1145: 
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.a.setPlayMode(Integer.parseInt(paramString));
          return true;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
          return false;
        }
      }
      return false;
    }
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        this.a.setAutoPlayMode(Integer.parseInt(paramString));
        return true;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lso(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lso
 * JD-Core Version:    0.7.0.1
 */