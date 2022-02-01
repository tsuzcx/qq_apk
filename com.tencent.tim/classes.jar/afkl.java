import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public final class afkl
  extends AsyncTask<Void, Void, Integer>
{
  public afkl(Bundle paramBundle, MessengerService paramMessengerService, URLDrawable paramURLDrawable, QQAppInterface paramQQAppInterface, PicMessageExtraData paramPicMessageExtraData) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    if (this.x.getStatus() != 1) {
      this.x.downloadImediatly(false);
    }
    URLDrawable.removeMemoryCacheByUrl(this.x.getURL().toString());
    paramVarArgs = ((MessageForPic)this.x.getTag()).path;
    paramVarArgs = EmojiStickerManager.a(this.val$app, paramVarArgs);
    if (paramVarArgs != null)
    {
      xtm.a(this.val$app, null, paramVarArgs);
      return Integer.valueOf(2);
    }
    paramVarArgs = this.x.getURL().toString();
    if (!aoiz.hasFile(paramVarArgs)) {
      return Integer.valueOf(1);
    }
    paramVarArgs = aoiz.getFile(paramVarArgs);
    if (paramVarArgs != null) {}
    label296:
    label307:
    for (paramVarArgs = SecUtil.getFileMd5(paramVarArgs.getAbsolutePath());; paramVarArgs = null)
    {
      if ((paramVarArgs == null) || ("".equals(paramVarArgs))) {
        return Integer.valueOf(1);
      }
      aqhq.UD(acbn.bmd + ".nomedia");
      String str2 = this.val$app.getCurrentAccountUin();
      int i;
      StringBuilder localStringBuilder;
      if ((this.a != null) && (this.a.isDiyDouTu()))
      {
        i = 1;
        if (i == 0) {
          break label307;
        }
        localStringBuilder = new StringBuilder().append("_diydoutu@");
        if (!TextUtils.isEmpty(this.a.emojiId)) {
          break label296;
        }
        str1 = "0";
      }
      label217:
      for (String str1 = str1;; str1 = "")
      {
        paramVarArgs = acbn.bmd + aczs.jH(str2) + paramVarArgs + str1 + ".jpg";
        try
        {
          this.x.saveTo(paramVarArgs);
          return Integer.valueOf(EmojiStickerManager.b(this.val$app, paramVarArgs, null, this.a));
        }
        catch (IOException paramVarArgs)
        {
          paramVarArgs.printStackTrace();
          QLog.d("EmojiStickerManager", 1, paramVarArgs, new Object[0]);
          return Integer.valueOf(1);
        }
        i = 0;
        break;
        str1 = this.a.emojiId;
        break label217;
      }
    }
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    int j = -1;
    int i;
    if (paramInteger.intValue() == 0) {
      i = 0;
    }
    for (;;)
    {
      paramInteger = new Bundle();
      paramInteger.putInt("result", i);
      this.aM.putBundle("response", paramInteger);
      this.val$service.cp(this.aM);
      return;
      i = j;
      if (paramInteger.intValue() != 2)
      {
        i = j;
        if (paramInteger.intValue() == 1) {
          i = -2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkl
 * JD-Core Version:    0.7.0.1
 */