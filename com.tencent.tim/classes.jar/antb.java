import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.now.NowVideoLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class antb
  extends anqv
{
  private QQAppInterface app;
  
  protected int IX()
  {
    return 18;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout18", 2, "getView.");
    }
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    paramContext.getResources();
    if ((paramBundle instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)paramBundle);
    }
    Object localObject2 = this.rz.iterator();
    paramBundle = null;
    if (((Iterator)localObject2).hasNext())
    {
      anqu localanqu = (anqu)((Iterator)localObject2).next();
      if (!"live".equals(localanqu.mTypeName)) {
        break label255;
      }
      paramBundle = (anry)localanqu;
    }
    label247:
    label255:
    for (;;)
    {
      break;
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsgItemLayout18", 2, "getView itemLive is null.");
        }
        return null;
      }
      if (paramView != null)
      {
        paramContext = (antb.a)paramView.getTag();
        localObject2 = null;
        localObject1 = paramView;
        paramView = paramContext;
        paramContext = (Context)localObject2;
        if (paramView != null) {
          break label247;
        }
        paramView = new antb.a();
        paramView.jdField_b_of_type_Anry = paramBundle;
        paramView.jdField_b_of_type_ComTencentBizNowNowVideoLayout = paramContext;
      }
      for (;;)
      {
        ((View)localObject1).setTag(paramView);
        paramView = ((View)localObject1).findViewById(2131378854);
        if (paramView != null) {
          paramView.setOnClickListener(paramBundle.mOnClickListener);
        }
        if (paramContext != null) {
          paramContext.a(this.app, paramBundle, this.e.message);
        }
        return localObject1;
        localObject2 = paramBundle.a(paramContext, null, null);
        paramContext = (NowVideoLayout)((View)localObject2).findViewById(2131378854);
        paramContext.azn();
        paramView = (View)localObject1;
        localObject1 = localObject2;
        break;
        paramContext = paramView.jdField_b_of_type_ComTencentBizNowNowVideoLayout;
      }
    }
  }
  
  public String getName()
  {
    return "Layout18";
  }
  
  public static class a
  {
    public anry b;
    public NowVideoLayout b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antb
 * JD-Core Version:    0.7.0.1
 */