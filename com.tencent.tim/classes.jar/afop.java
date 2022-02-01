import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class afop
{
  private static afop a;
  
  public static afop a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new afop();
      }
      return a;
    }
    finally {}
  }
  
  public afll a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, afmf paramafmf, BaseChatPie paramBaseChatPie, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelListViewAdapterBuilder", 2, "getAdapter panelType = " + paramInt2);
    }
    switch (paramInt2)
    {
    case 10: 
    case 11: 
    default: 
      return null;
    case 1: 
      return new afqq(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf, paramBaseChatPie, paramInt4);
    case 6: 
      return new aflm(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramafmf, paramBaseChatPie, paramInt4);
    case 8: 
      return new aflu(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramafmf, paramInt4);
    case 7: 
      return new afny(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramafmf, paramInt4);
    case 4: 
      return new afph(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf, paramBaseChatPie);
    case 5: 
      return new afpr(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf);
    case 3: 
      return new afqc(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf, paramInt4, paramBoolean);
    case 2: 
      return new afqj(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramafmf, paramBaseChatPie, paramInt4);
    case 9: 
      return new afql(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramafmf, paramInt4);
    case 12: 
      return new afnx(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramafmf);
    case 13: 
      return new aflw(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf, paramBaseChatPie);
    }
    return new afoa(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf, paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afop
 * JD-Core Version:    0.7.0.1
 */