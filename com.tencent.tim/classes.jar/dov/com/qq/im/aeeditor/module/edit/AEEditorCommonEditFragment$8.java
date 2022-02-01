package dov.com.qq.im.aeeditor.module.edit;

import android.support.v4.app.FragmentActivity;
import aoll;
import aolm;
import aomi;
import aqiw;
import axjj.a.a;
import axlr;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AEEditorCommonEditFragment$8
  implements Runnable
{
  AEEditorCommonEditFragment$8(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void run()
  {
    aoll localaoll = new aoll();
    localaoll.f = new axlr(this);
    localaoll.bZ = "https://downv6.qq.com/shadow_qqcamera/ProcessAnimation_b9f8fc550f1535b445b564bfbe0d82c5.zip";
    localaoll.mHttpMethod = 0;
    localaoll.atY = new File(axjj.a.a.cVb).getPath();
    localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
    localaoll.mExcuteTimeLimit = 30000L;
    try
    {
      this.this$0.getActivity().getAppInterface().getNetEngine(0).a(localaoll);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.8
 * JD-Core Version:    0.7.0.1
 */