import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class arzr
  implements DialogInterface.OnClickListener
{
  arzr(arzk paramarzk, boolean paramBoolean1, DialogInterface.OnClickListener paramOnClickListener, Bundle paramBundle, int paramInt1, boolean paramBoolean2, Activity paramActivity, String paramString1, boolean paramBoolean3, boolean paramBoolean4, String paramString2, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    arwt.d("MyAppApi", "---onConfirm--onClick");
    if (!arzk.aHx())
    {
      this.this$0.jdField_a_of_type_Arzk$d = new arzk.d(this.this$0);
      this.this$0.jdField_a_of_type_Arzk$d.autoDownload = this.val$autoDownload;
      this.this$0.jdField_a_of_type_Arzk$d.ddH = true;
      this.this$0.jdField_a_of_type_Arzk$d.t = this.V;
      this.this$0.jdField_a_of_type_Arzk$d.y = this.val$params;
      this.this$0.jdField_a_of_type_Arzk$d.dix = this.elo;
      if (this.ddF)
      {
        this.this$0.r(this.val$activity, this.cCm, 0);
        if ((this.this$0.jdField_a_of_type_Arzs != null) && (this.this$0.jdField_a_of_type_Arzs.isShowing())) {
          this.this$0.jdField_a_of_type_Arzs.iq(0, 1);
        }
      }
    }
    label632:
    for (;;)
    {
      paramDialogInterface = this.val$params.getString(aryv.PARAM_TASK_PACKNAME) + "_" + this.val$params.getString(aryv.PARAM_TASK_APPID) + "_" + this.val$params.getString(aryv.PARAM_TASK_APK_ID);
      this.this$0.ddB = true;
      arxt.br("201", arxt.cj(this.cCm, "NEWYYB"), this.cDL);
      paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 100 + "|" + paramDialogInterface;
      arub.a().postReport(25, paramDialogInterface);
      anot.a(null, "dc00898", "", "", "0X8008F7D", "0X8008F7D", 0, 0, "", "", "", "");
      if (this.elp == 1)
      {
        paramDialogInterface = this.val$params.getString("pageId") + "_" + this.val$params.getString("moduleId") + "_" + this.val$params.getString(aryv.PARAM_TASK_PACKNAME) + "_" + this.val$params.getString(aryv.PARAM_TASK_APPID) + "_" + this.val$params.getString(aryv.PARAM_TASK_APK_ID);
        arwk.q("6006", "1", "0", this.cCm, paramDialogInterface);
      }
      if (("ANDROID.QQ.YYBXZGAMECENTER".equals(this.cCm)) || ("ANDROID.QQ.NEWYYBXZGAMECENTER".equals(this.cCm))) {
        tbb.a(null, "765", "205010", this.cDL, "76501", "1", "156");
      }
      return;
      new arzk.c(this.this$0, this.val$activity, this.this$0.jdField_a_of_type_Arzk$d).execute(new Void[0]);
      continue;
      if ((aryq.aHs()) || (this.ddG)) {
        if (this.elo == 0) {
          this.this$0.a(this.val$activity, this.val$params, this.val$autoDownload, this.val$autoInstall);
        }
      }
      for (;;)
      {
        if ((this.this$0.jdField_a_of_type_Arzs == null) || (!this.this$0.jdField_a_of_type_Arzs.isShowing())) {
          break label632;
        }
        this.this$0.jdField_a_of_type_Arzs.dismiss();
        break;
        this.this$0.a(this.val$activity, this.val$params, this.val$autoDownload, this.val$autoInstall);
        continue;
        if (this.V != null) {
          this.V.onClick(null, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzr
 * JD-Core Version:    0.7.0.1
 */