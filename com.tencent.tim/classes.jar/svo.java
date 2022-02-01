import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

class svo
  implements BusinessObserver
{
  svo(svn paramsvn, ardm.k paramk) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ShareApiPlugin", 2, "onReceive, getUrlInfo, isSuccess=" + paramBoolean);
    }
    Object localObject1 = new Bundle();
    if (paramBoolean)
    {
      Object localObject2;
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Svn.aue)) || (this.jdField_a_of_type_Svn.aue.startsWith("http://")) || (this.jdField_a_of_type_Svn.aue.startsWith("https://")))
      {
        localObject2 = paramBundle.getString("extra_summary");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label626;
        }
        this.jdField_a_of_type_Svn.aue = ((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ShareApiPlugin", 2, "Use share summary parsed by server");
        }
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Svn.auf))
      {
        localObject2 = paramBundle.getStringArrayList("extra_images");
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          break label643;
        }
        this.jdField_a_of_type_Svn.auf = ((String)((ArrayList)localObject2).get(0));
        if (QLog.isColorLevel()) {
          QLog.d("ShareApiPlugin", 2, "Use share thumb parsed by server");
        }
      }
      label193:
      if (TextUtils.isEmpty(this.jdField_a_of_type_Svn.zc))
      {
        localObject2 = paramBundle.getString("extra_title");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label660;
        }
        this.jdField_a_of_type_Svn.zc = ((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ShareApiPlugin", 2, "Use share title parsed by server");
        }
      }
      label245:
      if (TextUtils.isEmpty(this.jdField_a_of_type_Svn.mShareUrl))
      {
        paramBundle = paramBundle.getString("extra_url");
        if (TextUtils.isEmpty(paramBundle)) {
          break label677;
        }
        this.jdField_a_of_type_Svn.mShareUrl = paramBundle;
        if (QLog.isColorLevel()) {
          QLog.d("ShareApiPlugin", 2, "Use share url parsed by server");
        }
      }
      label294:
      if (QLog.isColorLevel()) {
        QLog.e("shareWebPage", 2, "Share info after QZone rich: title=" + this.jdField_a_of_type_Svn.zc + ", summary=" + this.jdField_a_of_type_Svn.aue + ", thumb=" + this.jdField_a_of_type_Svn.auf + ", shareURL=" + this.jdField_a_of_type_Svn.mShareUrl);
      }
      ((Bundle)localObject1).putInt("extra_url_info_from", 5);
      label384:
      this.jdField_a_of_type_Ardm$k.a(this.jdField_a_of_type_Svn.zc, this.jdField_a_of_type_Svn.aue, this.jdField_a_of_type_Svn.mShareUrl, this.jdField_a_of_type_Svn.auf, (Bundle)localObject1);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Svn.auf)) {
        break label705;
      }
    }
    label643:
    label660:
    label677:
    label705:
    for (int i = 1;; i = 0)
    {
      paramInt = i;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Svn.aue)) {
        paramInt = i | 0x2;
      }
      i = paramInt;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Svn.zc)) {
        i = paramInt | 0x4;
      }
      paramBundle = new Bundle();
      paramBundle.putString("report_type", "102");
      paramBundle.putString("act_type", "91");
      localObject1 = new StringBuilder().append("");
      paramInt = j;
      if (i == 0) {
        paramInt = 0;
      }
      paramBundle.putString("intext_1", paramInt);
      paramBundle.putString("intext_2", "" + i);
      paramBundle.putString("stringext_1", "" + this.jdField_a_of_type_Svn.mShareUrl);
      arts.a().a(paramBundle, "", this.jdField_a_of_type_Svn.mRuntime.a().getAccount(), false);
      return;
      label626:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShareApiPlugin", 2, "Server can't resolve summary");
      break;
      if (!QLog.isColorLevel()) {
        break label193;
      }
      QLog.d("ShareApiPlugin", 2, "Server can't resolve thumb");
      break label193;
      if (!QLog.isColorLevel()) {
        break label245;
      }
      QLog.d("ShareApiPlugin", 2, "Server can't resolve title");
      break label245;
      if (!QLog.isColorLevel()) {
        break label294;
      }
      QLog.d("ShareApiPlugin", 2, "Server can't resolve url");
      break label294;
      ((Bundle)localObject1).putInt("extra_url_info_from", 3);
      break label384;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svo
 * JD-Core Version:    0.7.0.1
 */