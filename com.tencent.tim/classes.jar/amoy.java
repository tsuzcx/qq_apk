import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class amoy
  extends ampy
{
  private CharSequence ai;
  private CharSequence al;
  private AccountSearchPb.hotwordrecord jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
  private AccountSearchPb.record jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  private String cbq;
  private String keyword;
  
  public amoy(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = paramhotwordrecord;
    this.keyword = paramString1;
    this.al = paramCharSequence1;
    this.cbq = paramString2;
    this.ai = paramCharSequence2;
  }
  
  public amoy(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$record = paramrecord;
    this.keyword = paramString;
    this.al = paramCharSequence;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public AccountSearchPb.hotwordrecord a()
  {
    return this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
  }
  
  public AccountSearchPb.record a()
  {
    return this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  }
  
  public void cR(View paramView)
  {
    amxk.a(this.keyword, 110, 0, paramView);
    Intent localIntent = new Intent(paramView.getContext(), PublicAccountBrowser.class);
    if (this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null)
    {
      localIntent.putExtra("url", this.cbq);
      kbp.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, getKeyword(), this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "1");
    }
    for (;;)
    {
      paramView.getContext().startActivity(localIntent);
      if (this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) {
        kbp.b(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "", this.keyword, String.valueOf(this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$record.account_id.get()));
      }
      return;
      localIntent.putExtra("url", this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_short_url.get());
    }
  }
  
  public CharSequence f()
  {
    if (this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
      return this.ai;
    }
    return acfp.m(2131707039);
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public String getCoverUrl()
  {
    if (this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
      return this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_cover_url.get();
    }
    return this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$record.title_image.get();
  }
  
  public CharSequence getDescription()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null)
    {
      localObject1 = localObject2;
      if (this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.has()) {
        localObject1 = this.jdField_c_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.get();
      }
    }
    return localObject1;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    return this.al;
  }
  
  public String getUin()
  {
    return null;
  }
  
  public int pG()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amoy
 * JD-Core Version:    0.7.0.1
 */