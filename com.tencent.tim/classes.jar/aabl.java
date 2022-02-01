import Wallet.SkinInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aabl
{
  public static boolean buW;
  public static int cfZ = 0;
  public SkinInfo a;
  public RedPacketInfoBase a;
  public String arg = "";
  public int cfY;
  public String name = "";
  public int sort = -1;
  
  public aabl(SkinInfo paramSkinInfo)
  {
    this.jdField_a_of_type_WalletSkinInfo = new SkinInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = new RedPacketInfoBase();
    this.name = paramSkinInfo.skin_name;
    this.jdField_a_of_type_WalletSkinInfo = paramSkinInfo;
  }
  
  public aabl(String paramString)
  {
    this.jdField_a_of_type_WalletSkinInfo = new SkinInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = new RedPacketInfoBase();
    this.name = paramString;
  }
  
  public static void hu(List<aabl> paramList)
  {
    Collections.sort(paramList, new aabm());
  }
  
  public static int p(List<aabl> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aabl localaabl = (aabl)paramList.next();
      if (cfZ == localaabl.jdField_a_of_type_WalletSkinInfo.skin_id) {
        return localaabl.jdField_a_of_type_WalletSkinInfo.skin_id;
      }
    }
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof aabl)) {
        break;
      }
    } while (this.jdField_a_of_type_WalletSkinInfo.skin_id == ((aabl)paramObject).jdField_a_of_type_WalletSkinInfo.skin_id);
    return false;
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    localStringBuffer.append("background : " + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.background + " | ");
    localStringBuffer.append("icon : " + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon + " | ");
    return localStringBuffer.toString();
  }
  
  public static class a
  {
    public static aabl a(String paramString)
    {
      aabl localaabl = new aabl(acfp.m(2131707110));
      localaabl.cfY = -2;
      localaabl.jdField_a_of_type_WalletSkinInfo.skin_id = -2;
      localaabl.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
      localaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title = paramString;
      localaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon = null;
      localaabl.sort = 0;
      return localaabl;
    }
    
    public static aabl a(List<aabl> paramList, int paramInt)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aabl localaabl = (aabl)paramList.next();
        if (localaabl.jdField_a_of_type_WalletSkinInfo.skin_id == paramInt) {
          return localaabl;
        }
      }
      return null;
    }
    
    public static aabl b(String paramString)
    {
      aabl localaabl = new aabl(acfp.m(2131707112));
      localaabl.cfY = -1;
      localaabl.jdField_a_of_type_WalletSkinInfo.skin_id = 0;
      localaabl.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
      localaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title = paramString;
      localaabl.sort = -1;
      return localaabl;
    }
    
    public static aabl c(String paramString)
    {
      aabl localaabl = new aabl(acfp.m(2131707111));
      localaabl.arg = paramString;
      localaabl.cfY = 1;
      localaabl.sort = 1000;
      localaabl.jdField_a_of_type_WalletSkinInfo.skin_id = -1;
      localaabl.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
      return localaabl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabl
 * JD-Core Version:    0.7.0.1
 */