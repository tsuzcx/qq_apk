import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.FixRatioPAHighLightImageView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class ansr
  extends anqu
{
  public static int dMr = 1;
  public static int dMs = 2;
  public static int dMt = 3;
  public String aNt;
  public boolean cJQ;
  public String cii;
  public int height;
  public int mPicWidth = dMt;
  private URLDrawableDownListener.Adapter mUrlAdapter = new anss(this);
  public int width;
  
  public ansr()
  {
    this.mTypeName = "picture";
    this.mVersion = 17;
  }
  
  public ansr(String paramString)
  {
    this();
    this.aNt = paramString;
  }
  
  public ansr(String paramString1, String paramString2)
  {
    this();
    this.aNt = paramString1;
    this.cii = paramString2;
  }
  
  private URLDrawable a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    try
    {
      Object localObject1 = new URL(paramString);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt1;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt2;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = paramDrawable1;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = paramDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = paramBoolean1;
      ((URLDrawable.URLDrawableOptions)localObject2).mGifRoundCorner = 0.0F;
      ((URLDrawable.URLDrawableOptions)localObject2).mNeedCheckNetType = paramBoolean2;
      ((URLDrawable.URLDrawableOptions)localObject2).mRetryCount = 3;
      ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = paramObject;
      paramString = new aoli();
      paramString.businessType = 1001;
      if (this.e != null)
      {
        paramString.dPw = this.e.mMsgServiceID;
        paramString.dPx = this.e.mMsgTemplateID;
        if (this.e.message != null) {
          paramString.clN = String.valueOf(this.e.message.istroop);
        }
      }
      ((URLDrawable.URLDrawableOptions)localObject2).mHttpDownloaderParams = paramString;
      localObject2 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      if ("url.cn".equals(((URL)localObject1).getHost()))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramDrawable1;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = paramDrawable2;
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = paramBoolean1;
        ((URLDrawable.URLDrawableOptions)localObject1).mGifRoundCorner = 0.0F;
        ((URLDrawable.URLDrawableOptions)localObject1).mNeedCheckNetType = paramBoolean2;
        ((URLDrawable.URLDrawableOptions)localObject1).mRetryCount = 3;
        ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = paramObject;
        ((URLDrawable.URLDrawableOptions)localObject1).mHttpDownloaderParams = paramString;
        ((URLDrawable)localObject2).setTag(localObject1);
      }
      return localObject2;
    }
    catch (MalformedURLException paramDrawable1)
    {
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
  }
  
  public static Bitmap e(Drawable paramDrawable)
  {
    try
    {
      int i = paramDrawable.getIntrinsicWidth();
      if (paramDrawable.getOpacity() != -1) {}
      for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
      {
        localObject = Bitmap.createBitmap(i, i, (Bitmap.Config)localObject);
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        paramDrawable.setBounds(0, 0, i, i);
        paramDrawable.draw(localCanvas);
        paramDrawable = aqhu.b((Bitmap)localObject, i, i, i);
        ((Bitmap)localObject).recycle();
        return paramDrawable;
      }
      return null;
    }
    catch (Exception paramDrawable)
    {
      return null;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      QLog.e("StructMsgItemCover", 2, "getRoundedCornerBitmap  OutOfMemoryError");
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return a(paramContext, paramView, false, paramBundle);
  }
  
  public View a(Context paramContext, View paramView, boolean paramBoolean, Bundle paramBundle)
  {
    this.cJQ = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("[@]", 2, "StructMsgItemCover createView start! mUrlString = " + this.aNt);
    }
    boolean bool2;
    if (paramBundle != null) {
      bool2 = paramBundle.getBoolean("pre_dialog");
    }
    boolean bool1;
    Object localObject3;
    int i;
    Object localObject1;
    Object localObject2;
    Drawable localDrawable2;
    for (;;)
    {
      if (paramBundle == null) {
        break label2029;
      }
      bool1 = paramBundle.getBoolean("pa_should_change");
      localObject3 = paramContext.getResources();
      i = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      try
      {
        Drawable localDrawable1 = kcx.a().c((Resources)localObject3, 2130851465);
        if ((paramView != null) && ((paramView instanceof PAImageView)))
        {
          localObject1 = (PAHighLightImageView)paramView;
          localObject2 = paramView;
          ((PAHighLightImageView)localObject1).setTag(this);
          paramView = this.aNt;
          if ((TextUtils.isEmpty(paramView)) && (paramBundle != null) && (paramBundle.containsKey("extend-data-json")) && (paramBundle.getInt("serviceID", 0) == 128))
          {
            paramBundle = paramBundle.getString("extend-data-json");
            if (TextUtils.isEmpty(paramBundle)) {}
          }
        }
        else
        {
          try
          {
            if (!(paramContext instanceof BaseActivity)) {
              break label318;
            }
            paramBundle = new JSONObject(paramBundle);
            ((PAHighLightImageView)localObject1).setImageDrawable(aqdj.a(((BaseActivity)paramContext).app, 4, paramBundle.optString("groupcode")));
            ((PAHighLightImageView)localObject1).setBackgroundDrawable(null);
            return localObject2;
          }
          catch (Throwable paramContext)
          {
            QLog.d("StructMsgItemCover", 1, "createView error:" + paramContext.getMessage());
          }
          bool2 = false;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localDrawable2 = null;
          continue;
          localObject2 = new FixRatioPAHighLightImageView(paramContext);
          ((PAHighLightImageView)localObject2).setId(2131369004);
          ((PAHighLightImageView)localObject2).setContentDescription(((Resources)localObject3).getString(2131692253));
          localObject1 = localObject2;
        }
      }
    }
    label318:
    if (TextUtils.isEmpty(paramView))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[@]", 2, "StructMsgItemCover createView ,url = " + paramView);
      }
      ((PAHighLightImageView)localObject1).setImageDrawable(localDrawable2);
      ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (bool1) {
        ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe2"));
      }
      for (;;)
      {
        if ((this.cgX != null) && (!this.cgX.equals("")))
        {
          ((View)localObject2).setClickable(true);
          ((View)localObject2).setOnClickListener(this);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("[@]", 2, "StructMsgItemCover createView end!");
        return localObject2;
        ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe4"));
      }
    }
    label388:
    label553:
    label633:
    label2046:
    for (;;)
    {
      int j;
      try
      {
        if ((paramView.startsWith("http://")) || (paramView.startsWith("https://"))) {
          break label1231;
        }
        boolean bool3 = paramView.startsWith("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, "https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".length() - 2));
        if (bool3) {
          break label1231;
        }
        try
        {
          if (!paramView.startsWith("mqqapi://card")) {
            break label1112;
          }
          i = paramView.lastIndexOf("&uin=");
          if (i != -1) {
            break label759;
          }
          if (QLog.isColorLevel()) {
            QLog.e("StructMsgItemCover", 2, "createView, error: index is -1");
          }
          ((PAHighLightImageView)localObject1).setImageDrawable(aqhu.aU());
          return localObject2;
        }
        catch (MalformedURLException paramContext)
        {
          i = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.e("StructMsgItemCover", 2, "createView, error: " + paramContext.getMessage());
        }
        ((PAHighLightImageView)localObject1).setImageDrawable(aqhu.aU());
        paramContext = null;
        if ((paramContext == null) || (paramContext.getStatus() != 1)) {
          break label1958;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,set null");
        }
        ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (paramBoolean) {
          ((PAHighLightImageView)localObject1).setBackgroundDrawable(null);
        }
        if ((paramContext == null) || (!paramBoolean)) {
          break label1985;
        }
        j = i;
        if (i == 0) {
          j = paramContext.getIntrinsicWidth();
        }
        paramContext.setTag(aqbn.d(j, j, j));
        paramContext.setDecodeHandler(aqbn.a);
        ((PAHighLightImageView)localObject1).setImageDrawable(paramContext);
        if (paramContext.getStatus() == 1) {
          break label388;
        }
        paramContext.restartDownload();
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label749;
        }
      }
      if ("StructMsgItemCover createView ,exception  = " + paramContext != null)
      {
        paramContext = paramContext.getMessage();
        QLog.d("StructMsgItemCover", 2, paramContext);
        ((PAHighLightImageView)localObject1).setImageDrawable(localDrawable2);
        break label388;
        paramContext = paramView.substring("&uin=".length() + i);
        i = paramContext.lastIndexOf("&");
        paramBundle = paramContext;
        if (i != -1) {
          paramBundle = paramContext.substring(0, i);
        }
        if (localObject2 != null)
        {
          localObject3 = ((View)localObject2).getContext();
          if ((localObject3 instanceof BaseActivity))
          {
            ((PAHighLightImageView)localObject1).text = "";
            QQAppInterface localQQAppInterface = ((BaseActivity)localObject3).app;
            paramContext = aqhu.aU();
            if (paramView.indexOf("internal_phone") > -1)
            {
              i = paramView.indexOf("&headtext=");
              paramContext = "";
              if (i != -1)
              {
                j = paramView.indexOf("&", i + 1);
                if (j == -1) {
                  paramContext = paramView.substring("&headtext=".length() + i);
                }
              }
              else
              {
                paramContext = URLDecoder.decode(paramContext);
                if (TextUtils.isEmpty(paramContext.trim())) {
                  break label1053;
                }
                if (!bool2) {
                  break label1014;
                }
                if (!aqgv.mH(paramContext)) {
                  break label998;
                }
                i = ((Context)localObject3).getResources().getDimensionPixelSize(2131299566);
                ((PAHighLightImageView)localObject1).setTextSize(i);
                ((PAHighLightImageView)localObject1).text = paramContext;
                paramContext = ((Context)localObject3).getResources().getDrawable(2130842937);
              }
            }
            for (;;)
            {
              ((PAHighLightImageView)localObject1).setImageDrawable(paramContext);
              return localObject2;
              paramContext = paramView.substring(i + "&headtext=".length(), j);
              break;
              i = ((Context)localObject3).getResources().getDimensionPixelSize(2131299568);
              break label945;
              if (aqgv.mH(paramContext))
              {
                i = ((Context)localObject3).getResources().getDimensionPixelSize(2131299562);
                break label945;
              }
              i = ((Context)localObject3).getResources().getDimensionPixelSize(2131299564);
              break label945;
              if (paramBundle.startsWith("+"))
              {
                paramContext = aqdj.b(localQQAppInterface, paramBundle, (byte)3);
              }
              else
              {
                paramContext = aqdj.g(11, 3);
                continue;
                paramContext = aqdj.a(localQQAppInterface, 1, paramBundle, 3, paramContext, paramContext);
              }
            }
          }
        }
        ((PAHighLightImageView)localObject1).setImageDrawable(aqhu.aU());
        return localObject2;
        if (paramView.startsWith("troop_notice"))
        {
          ((PAHighLightImageView)localObject1).setImageResource(2130844672);
          return localObject2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,begin decode");
        }
        paramContext = new File(paramView).toURL().toString();
        for (;;)
        {
          for (;;)
          {
            try
            {
              if (this.mPicWidth == dMr)
              {
                j = wja.dp2px(70.0F, (Resources)localObject3);
                i = j;
              }
            }
            catch (MalformedURLException paramContext) {}
            try
            {
              paramContext = URLDrawable.getDrawable(paramContext, i, i, localDrawable2, localDrawable2, true);
            }
            catch (MalformedURLException paramContext) {}
          }
          if (this.mPicWidth != dMs) {
            break label2026;
          }
          j = wja.dp2px(140.0F, (Resources)localObject3);
          i = j;
          continue;
          paramBundle = null;
          if (paramView.startsWith("https://p.qlogo.cn/gh/"))
          {
            j = paramView.lastIndexOf("gh/");
            paramContext = paramView.substring("gh/".length() + j).split("/")[0];
            if (TextUtils.isEmpty(paramContext)) {
              break label2035;
            }
            paramView = ((View)localObject2).getContext();
            if ((paramView instanceof BaseActivity))
            {
              paramView = ((BaseActivity)paramView).app;
              paramBundle = aqdj.g(4, 3);
              ((PAHighLightImageView)localObject1).setImageDrawable(aqdj.a(paramView, 4, paramContext, 3, paramBundle, paramBundle));
              return localObject2;
            }
            ((PAHighLightImageView)localObject1).setImageDrawable(aqhu.aU());
            return localObject2;
          }
        }
      }
      for (;;)
      {
        if (this.mPicWidth == dMr)
        {
          ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
          i = wja.dp2px(70.0F, (Resources)localObject3);
          if (!bool1) {
            break label1944;
          }
          ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe2"));
        }
        for (;;)
        {
          paramContext = a(paramContext, i, i, localDrawable2, localDrawable2, true, true, paramView);
          if (paramContext.getTag() == null) {
            paramContext.setTag(Integer.valueOf(0));
          }
          paramContext.setAutoDownload(true);
          if (paramContext.getStatus() != 2) {
            break label2046;
          }
          paramContext.restartDownload();
          break label2046;
          if ((paramView.startsWith(smu.aEN)) || (paramView.startsWith(smu.aEO)) || (paramView.startsWith(smu.aEP)))
          {
            ((PAHighLightImageView)localObject1).setBackgroundDrawable(null);
            i = paramView.lastIndexOf("&uin=");
            paramContext = paramView.substring("&uin=".length() + i);
            paramView = ((View)localObject2).getContext();
            if ((paramView instanceof BaseActivity))
            {
              ((PAHighLightImageView)localObject1).setImageDrawable(((BaseActivity)paramView).app.a(paramContext, false, (byte)2));
              return localObject2;
            }
            ((PAHighLightImageView)localObject1).setImageDrawable(aqhu.aU());
            return localObject2;
          }
          if (paramView.startsWith("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, "https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".length() - 2)))
          {
            paramContext = new ColorDrawable(0);
            ((PAHighLightImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(paramView, paramContext, paramContext));
            return localObject2;
          }
          if ((paramView.startsWith("http://imgplat.store.qq.com/bqq_qfpic/520520")) || (paramView.contains(siu.aEm)))
          {
            paramBoolean = true;
            this.cJQ = true;
            paramBundle = null;
            paramContext = paramView;
            paramView = paramBundle;
            break;
          }
          if ((this.cii != null) && (this.cii.equals("1")))
          {
            paramBoolean = true;
            this.cJQ = true;
            paramBundle = null;
            paramContext = paramView;
            paramView = paramBundle;
            break;
          }
          bool2 = paramView.startsWith("http://qqpublic.qpic.cn");
          if (bool2)
          {
            for (;;)
            {
              for (;;)
              {
                try
                {
                  if (new URL(paramView).getQuery() != null)
                  {
                    paramContext = "&spec=screen";
                    if (this.mPicWidth == dMr)
                    {
                      paramContext = "&spec=small";
                      new String(paramView);
                      paramContext = paramView + paramContext;
                      paramView = paramBundle;
                    }
                  }
                }
                catch (MalformedURLException paramContext) {}
                try
                {
                  if (this.e != null)
                  {
                    paramView = paramBundle;
                    if (this.e.message != null) {
                      paramView = this.e.message;
                    }
                  }
                }
                catch (MalformedURLException paramView)
                {
                  for (;;)
                  {
                    paramView = paramContext;
                  }
                }
              }
              if (this.mPicWidth == dMs)
              {
                paramContext = "&spec=middle";
                continue;
                paramContext = "?spec=screen";
                if (this.mPicWidth == dMr) {
                  paramContext = "?spec=small";
                } else if (this.mPicWidth == dMs) {
                  paramContext = "?spec=middle";
                }
              }
            }
            throw new IllegalArgumentException("illegal url format: " + paramView);
          }
          if ((this.e == null) || (this.e.message == null) || (this.e.message.istroop != 1008)) {
            break label2015;
          }
          paramBundle = this.e.message;
          paramContext = paramView;
          paramView = paramBundle;
          break;
          if (this.mPicWidth == dMs)
          {
            ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER);
            i = wja.dp2px(140.0F, (Resources)localObject3);
            break label1368;
          }
          ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER);
          break label1368;
          ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe4"));
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,set listener");
        }
        ((PAHighLightImageView)localObject1).setURLDrawableDownListener(this.mUrlAdapter);
        break label633;
        ((PAHighLightImageView)localObject1).setImageDrawable(paramContext);
        break label388;
        paramContext = " happens error ";
        break label742;
        break label553;
        break label553;
        paramBundle = null;
        paramContext = paramView;
        paramView = paramBundle;
        continue;
        break label1187;
        bool1 = false;
        break;
        paramBundle = null;
        paramContext = paramView;
        paramView = paramBundle;
      }
    }
  }
  
  StructMsgForGeneralShare a(View paramView)
  {
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131378856) {
        return (StructMsgForGeneralShare)paramView.getTag(2131378856);
      }
    }
    return null;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "picture");
    if (this.aNt == null) {}
    for (String str = "";; str = this.aNt)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      if (this.mVersion > 3)
      {
        if (!TextUtils.isEmpty(this.cgX)) {
          paramXmlSerializer.attribute(null, "action", this.cgX);
        }
        if (!TextUtils.isEmpty(this.ku)) {
          paramXmlSerializer.attribute(null, "url", this.ku);
        }
        if (this.mVersion > 5)
        {
          if (!TextUtils.isEmpty(this.index)) {
            paramXmlSerializer.attribute(null, "index", this.index);
          }
          if (!TextUtils.isEmpty(this.index_name)) {
            paramXmlSerializer.attribute(null, "index_name", this.index_name);
          }
          if (!TextUtils.isEmpty(this.index_type)) {
            paramXmlSerializer.attribute(null, "index_type", this.index_type);
          }
          paramXmlSerializer.attribute(null, "w", String.valueOf(this.width));
          paramXmlSerializer.attribute(null, "h", String.valueOf(this.height));
          if ((this.mVersion > 8) && (!TextUtils.isEmpty(this.cii))) {
            paramXmlSerializer.attribute(null, "needRoundView", this.cii);
          }
        }
      }
      paramXmlSerializer.endTag(null, "picture");
      return;
    }
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {}
    String str;
    label18:
    do
    {
      do
      {
        return true;
        str = paramansf.getAttribute("cover");
        if (str == null) {
          break;
        }
        this.aNt = str;
      } while (this.mVersion <= 3);
      this.cgX = paramansf.getAttribute("action");
      this.ku = paramansf.getAttribute("url");
    } while (this.mVersion <= 5);
    this.index = paramansf.getAttribute("index");
    this.index_name = paramansf.getAttribute("index_name");
    this.index_type = paramansf.getAttribute("index_type");
    for (;;)
    {
      try
      {
        str = paramansf.getAttribute("w");
        if (str != null) {
          continue;
        }
        i = 0;
        this.width = i;
        str = paramansf.getAttribute("h");
        if (str != null) {
          continue;
        }
        i = 0;
        this.height = i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i;
        this.width = 0;
        this.height = 0;
        continue;
      }
      if (this.mVersion <= 8) {
        break;
      }
      this.cii = paramansf.getAttribute("needRoundView");
      return true;
      str = "";
      break label18;
      i = Integer.parseInt(str);
      continue;
      i = Integer.parseInt(str);
    }
  }
  
  public void b(AbsShareMsg paramAbsShareMsg)
  {
    paramAbsShareMsg.mContentCover = this.aNt;
  }
  
  public String getLayoutStr()
  {
    return "Cover";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.aNt = paramObjectInput.readUTF();
    if (this.mVersion <= 3) {}
    do
    {
      do
      {
        return;
        this.cgX = paramObjectInput.readUTF();
        this.ku = paramObjectInput.readUTF();
      } while (this.mVersion <= 5);
      this.index = paramObjectInput.readUTF();
      this.index_name = paramObjectInput.readUTF();
      this.index_type = paramObjectInput.readUTF();
      this.width = paramObjectInput.readInt();
      this.height = paramObjectInput.readInt();
    } while (this.mVersion <= 8);
    this.cii = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.aNt == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mVersion > 3) {
        break label40;
      }
    }
    label40:
    label69:
    label95:
    label113:
    do
    {
      do
      {
        return;
        str = this.aNt;
        break;
        if (this.cgX != null) {
          break label186;
        }
        str = "";
        paramObjectOutput.writeUTF(str);
        if (this.ku != null) {
          break label194;
        }
        str = "";
        paramObjectOutput.writeUTF(str);
      } while (this.mVersion <= 5);
      if (this.index != null) {
        break label202;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.index_name != null) {
        break label210;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.index_type != null) {
        break label218;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.width);
      paramObjectOutput.writeInt(this.height);
    } while (this.mVersion <= 8);
    label131:
    if (this.cii == null) {}
    for (String str = "";; str = this.cii)
    {
      paramObjectOutput.writeUTF(str);
      return;
      label186:
      str = this.cgX;
      break;
      label194:
      str = this.ku;
      break label69;
      label202:
      str = this.index;
      break label95;
      label210:
      str = this.index_name;
      break label113;
      label218:
      str = this.index_type;
      break label131;
    }
  }
  
  public void z(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = wja.a(paramView);
      localObject1 = localObject2;
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject2;
      label13:
      Object localObject3;
      break label13;
    }
    if (localObject1 == null) {}
    do
    {
      return;
      localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
    } while ((TextUtils.isEmpty((CharSequence)localObject3)) || (!this.aNt.endsWith("gif")));
    localObject1 = "0";
    localObject2 = ((FragmentActivity)paramView.getContext()).getChatFragment();
    if (localObject2 == null) {}
    for (localObject2 = null;; localObject2 = ((ChatFragment)localObject2).getApp())
    {
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        if (((JSONObject)localObject3).has("ad_id")) {
          localObject1 = ((JSONObject)localObject3).getString("ad_id");
        }
      }
      catch (Exception localException)
      {
        String str;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("StructMsgItemCover", 2, "parse ad_id error");
          }
          str = "0";
        }
        anot.b((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, str, String.valueOf(paramView.msgId), "1", "");
        return;
      }
      paramView = a(paramView);
      if (paramView != null) {
        break label168;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StructMsgItemCover", 2, "StructMsgForGeneralShare == NULL");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansr
 * JD-Core Version:    0.7.0.1
 */