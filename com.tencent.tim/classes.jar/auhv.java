import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.cloudfile.CloudFileDirBrowserActivity;
import java.util.Arrays;

class auhv
  extends atgd
{
  auhv(auhu paramauhu) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, atin paramatin, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte, paramatin, paramString);
    if ((Arrays.equals(auhu.a(this.a), paramArrayOfByte)) && (this.a.a != null) && (this.a.a.Pp()))
    {
      this.a.a.ehM();
      if (!paramBoolean) {
        break label236;
      }
      paramArrayOfByte = aueh.a(paramatin);
      paramArrayOfByte.setPath("/" + paramArrayOfByte.getName());
      paramatin = new Intent(this.a.context, CloudFileDirBrowserActivity.class);
      auhu.a(this.a).putParcelable("key_file_info", paramArrayOfByte);
      paramatin.putExtras(auhu.a(this.a));
      if (paramatin.getIntExtra("key_bottom_bar_right_action", -1) != 3) {
        break label166;
      }
      auhu.a(this.a, this.a.context, 9, paramatin);
    }
    label166:
    label236:
    while ((this.a.a == null) || (!this.a.a.Pp()))
    {
      return;
      if (paramatin.getIntExtra("key_bottom_bar_right_action", -1) == 1)
      {
        auhu.a(this.a, this.a.context, 9, paramatin);
        return;
      }
      if (paramatin.getIntExtra("key_bottom_bar_right_action", -1) == 5)
      {
        auhu.a(this.a, this.a.context, 9, paramatin);
        return;
      }
      this.a.context.startActivity(paramatin);
      return;
    }
    if (paramString != null) {}
    for (;;)
    {
      this.a.a.al(false, paramString);
      return;
      paramString = BaseApplicationImpl.getContext().getString(2131691573);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhv
 * JD-Core Version:    0.7.0.1
 */