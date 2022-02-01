import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.debug.EnvSwitchActivity;
import com.tencent.mobileqq.qipc.QIPCModule;
import dov.com.qq.im.ae.SessionWrap;
import eipc.EIPCResult;
import java.io.ByteArrayOutputStream;

public class axil
  extends QIPCModule
{
  public axil()
  {
    super("AECameraGetInfoServer");
  }
  
  public static axil a()
  {
    return axil.a.a;
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  private QQAppInterface getAppInterface()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  private String sF(@NonNull String paramString)
  {
    if (paramString.contains("14.18.180.90")) {
      return "IPv4";
    }
    if (paramString.contains("240e:e1:a900:50::18")) {
      return "IPv6";
    }
    return "Unknown";
  }
  
  public byte[] Bitmap2Bytes(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject1 = getAppInterface();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2;
    if ("WATER_MARK_GET_PROFILE_PHOTO".equals(paramString))
    {
      paramBundle = (acff)((QQAppInterface)localObject1).getManager(51);
      if (paramBundle != null)
      {
        paramString = ((QQAppInterface)localObject1).getCurrentUin();
        paramBundle = paramBundle.c(paramString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("QQ_NUMBER", paramString);
        ((Bundle)localObject2).putInt("QQ_LEVEL", paramBundle.iQQLevel);
        ((Bundle)localObject2).putInt("QQ_VIP_LEVEL", paramBundle.iSuperVipLevel);
        ((Bundle)localObject2).putShort("QQ_SEX", paramBundle.shGender);
        ((Bundle)localObject2).putString("QQ_NICKNAME", paramBundle.strNick);
        ((Bundle)localObject2).putByteArray("PROFILE_PHOTO", Bitmap2Bytes(drawableToBitmap(aqdj.a((AppInterface)localObject1, paramString, (byte)1))));
        return EIPCResult.createResult(0, (Bundle)localObject2);
      }
    }
    else if ("WATER_MARK_GET_QQCARD_FRIENDINFO".equals(paramString))
    {
      localObject2 = (acff)((QQAppInterface)localObject1).getManager(51);
      if (localObject2 != null)
      {
        paramString = paramBundle.getString("friend");
        paramBundle = ((acff)localObject2).c(paramString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("QQ_NUMBER", paramString);
        ((Bundle)localObject2).putInt("QQ_LEVEL", paramBundle.iQQLevel);
        ((Bundle)localObject2).putInt("QQ_VIP_LEVEL", paramBundle.iSuperVipLevel);
        ((Bundle)localObject2).putShort("QQ_SEX", paramBundle.shGender);
        ((Bundle)localObject2).putString("QQ_NICKNAME", paramBundle.strNick);
        ((Bundle)localObject2).putByteArray("PROFILE_PHOTO", Bitmap2Bytes(drawableToBitmap(aqdj.a((AppInterface)localObject1, paramString, (byte)1))));
        return EIPCResult.createResult(0, (Bundle)localObject2);
      }
    }
    else
    {
      if ("ACTION_GET_ENV_INFO".equals(paramString))
      {
        paramBundle = new Bundle();
        if (EnvSwitchActivity.isTestEnvironment())
        {
          localObject1 = EnvSwitchActivity.loadTestEnvironment()[0];
          paramString = "Unknown";
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            paramString = sF((String)localObject1);
          }
          paramBundle.putString("KEY_ENV_INFO", "Test Env: " + paramString);
        }
        for (;;)
        {
          paramString = EIPCResult.createSuccessResult(paramBundle);
          callbackResult(paramInt, paramString);
          return paramString;
          paramBundle.putString("KEY_ENV_INFO", "Prod Env");
        }
      }
      if ("ACTION_SEND_GIF".equals(paramString)) {
        if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          break label518;
        }
      }
    }
    label518:
    for (paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramString = null)
    {
      if (paramString == null) {
        return null;
      }
      localObject1 = new SessionWrap(paramBundle.getString("curFriendUin"), paramBundle.getString("curFriendNick"), paramBundle.getInt("curType"), paramBundle.getString("troopUin"));
      localObject2 = new aflv();
      ((aflv)localObject2).path = paramBundle.getString("ARG_GIF_PATH");
      ((aflv)localObject2).url = ((aflv)localObject2).path;
      ((aflv)localObject2).bDY = paramBundle.getString("forward_summary_extra", "");
      ((aflv)localObject2).templateId = paramBundle.getString("widgetinfo", "");
      ((aflv)localObject2).a(paramString, BaseApplicationImpl.getContext(), null, ((SessionWrap)localObject1).c());
      return null;
      return null;
    }
  }
  
  static class a
  {
    public static axil a = new axil();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axil
 * JD-Core Version:    0.7.0.1
 */