import android.text.TextUtils;

public class aldd
{
  public String bVN;
  public String bVO;
  public String bVP;
  public String bVQ;
  public boolean cwg;
  public boolean cwh;
  public int drZ;
  public int dsa;
  public int dsb;
  public int dsc;
  public int dsd;
  public int dse;
  
  private String xT()
  {
    switch (this.dsb)
    {
    default: 
      return "";
    case 4: 
      return acfp.m(2131714051);
    case 5: 
      return acfp.m(2131714049);
    case 6: 
      return acfp.m(2131714047);
    case 7: 
      return acfp.m(2131714048);
    case 8: 
      return acfp.m(2131714052);
    }
    return acfp.m(2131714050);
  }
  
  public int Hu()
  {
    switch (this.dsa)
    {
    default: 
      return 8;
    case 1: 
      return 10;
    }
    return 9;
  }
  
  public String toString()
  {
    return "uint32_idx:" + this.drZ + " uint32_category:" + this.dsa + " str_school_id:" + this.bVN + " str_school_name:" + this.bVO + " str_department_id:" + this.bVP + " str_department_name:" + this.bVQ + " uint32_degree:" + this.dsb + " uint32_enrollment_year:" + this.dsc + " uint32_graduation_year:" + this.dsd + " uint32_allow_recommend:" + this.dse;
  }
  
  public String xR()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.dsa == 3)
    {
      if (!TextUtils.isEmpty(this.bVO)) {
        localStringBuilder.append(this.bVO).append(" ");
      }
      if (this.dsc > 0) {
        localStringBuilder.append(this.dsc).append("级").append(" ");
      }
      if (!TextUtils.isEmpty(this.bVQ))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(" ");
        }
        localStringBuilder.append(this.bVQ);
      }
      if (this.dsb > 0)
      {
        String str = xT();
        if (!TextUtils.isEmpty(str))
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append(" ");
          }
          localStringBuilder.append(str);
        }
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (!TextUtils.isEmpty(this.bVO)) {
        localStringBuilder.append(this.bVO).append(" ");
      }
      if (this.dsc > 0) {
        localStringBuilder.append(this.dsc).append("级");
      }
    }
  }
  
  public String xS()
  {
    switch (this.dsa)
    {
    default: 
      return "大学";
    case 1: 
      return "小学";
    }
    return "中学";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aldd
 * JD-Core Version:    0.7.0.1
 */