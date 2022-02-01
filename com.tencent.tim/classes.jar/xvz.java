import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;

public class xvz
{
  public static xvg a(QQAppInterface paramQQAppInterface, xvt paramxvt, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, CustomizeStrategyFactory.c paramc)
  {
    switch (paramInt)
    {
    default: 
      return new xvb(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    case 1: 
      return new xvi(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    case 5: 
      return new xvj(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    case 2: 
      return new xwb(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    case 3: 
      return new xvy(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    case 4: 
      return new xwa(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    case 6: 
      return new xvw(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    case 7: 
      return new xve(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    case 8: 
      return new xvh(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    case 9: 
      return new xvd(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    case 10: 
      return new xvv(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    case 11: 
      return new xvc(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    }
    return new xvf(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
  }
  
  public static int fm(int paramInt)
  {
    int i = 5;
    QLog.i("ViewHolderFactory", 2, "CFT-debug messageType = " + paramInt);
    if (paramInt == 6) {
      i = 1;
    }
    while (paramInt == 14) {
      return i;
    }
    if ((paramInt == 13) || (paramInt == 15)) {
      return 2;
    }
    if ((paramInt == 4) || (paramInt == 5)) {
      return 3;
    }
    if (paramInt == 2001) {
      return 4;
    }
    if ((paramInt == 7) || (paramInt == 8) || (paramInt == 11) || (paramInt == 12)) {
      return 6;
    }
    if (paramInt == 2002) {
      return 7;
    }
    if (paramInt == 18) {
      return 8;
    }
    if (paramInt == 19) {
      return 9;
    }
    if ((paramInt == 21) || (paramInt == 24) || (paramInt == 25)) {
      return 10;
    }
    if (paramInt == 22) {
      return 11;
    }
    if (paramInt == 23) {
      return 12;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvz
 * JD-Core Version:    0.7.0.1
 */