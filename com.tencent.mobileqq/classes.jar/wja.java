import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class wja
  extends SosoInterface.OnLocationListener
{
  public wja(SearchContactsFragment paramSearchContactsFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      SearchContactsFragment.a(this.a, paramSosoLbsInfo.a.a);
      SearchContactsFragment.b(this.a, paramSosoLbsInfo.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wja
 * JD-Core Version:    0.7.0.1
 */