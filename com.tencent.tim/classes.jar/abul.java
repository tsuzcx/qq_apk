import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class abul
  implements abto.b
{
  abul(abuk paramabuk, JSONArray paramJSONArray, File paramFile, AppInterface paramAppInterface, String paramString1, int[] paramArrayOfInt, String paramString2) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    QLog.d("ApolloPluginRscLoader", 1, new Object[] { "getCombination onDownLoadFinish sucess:", Boolean.valueOf(paramBoolean) });
    label75:
    int i;
    if (paramInt1 > 0)
    {
      paramString = this.a;
      if (ApolloUtil.ih(paramInt1))
      {
        paramInt2 = 0;
        paramString = abuk.a(paramString, 1, String.valueOf(paramInt1), paramInt2);
        this.val$jsonArray.put(paramString);
      }
    }
    else
    {
      if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
        break label147;
      }
      paramInt1 = 0;
      if (paramInt1 >= paramArrayOfInt.length) {
        break label147;
      }
      paramString = this.a;
      i = paramArrayOfInt[paramInt1];
      if (!ApolloUtil.ig(paramArrayOfInt[paramInt1])) {
        break label141;
      }
    }
    label141:
    for (paramInt2 = 0;; paramInt2 = 2)
    {
      paramString = abuk.a(paramString, 2, String.valueOf(i), paramInt2);
      this.val$jsonArray.put(paramString);
      paramInt1 += 1;
      break label75;
      paramInt2 = 2;
      break;
    }
    label147:
    if ((this.ae != null) && (!this.ae.exists()))
    {
      abto.a(this.b, this.bhV, new abum(this));
      return;
    }
    if (!TextUtils.isEmpty(this.bhV))
    {
      paramString = abuk.a(this.a, 6, this.bhV, 0);
      this.val$jsonArray.put(paramString);
    }
    if ((this.jW == null) || (this.jW.length <= 0))
    {
      this.a.a(this.val$callbackId, acfp.m(2131702631), this.val$jsonArray);
      return;
    }
    abuk.a(this.a, this.jW, this.val$callbackId, this.val$jsonArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abul
 * JD-Core Version:    0.7.0.1
 */