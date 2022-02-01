import com.tencent.mobileqq.data.Card;
import java.text.DateFormat;
import java.util.Date;

public class vjj
  extends vji
{
  public long a;
  public long b;
  public String c;
  
  public vjj(vhv paramvhv, int paramInt)
  {
    super(paramvhv);
    if (paramvhv.e == 1) {}
    for (;;)
    {
      yos.a(bool);
      this.c = paramvhv.jdField_a_of_type_JavaLangString;
      int i = paramInt;
      if (paramInt == 0) {
        i = paramvhv.jdField_a_of_type_Int;
      }
      String str = i + "-" + paramvhv.jdField_b_of_type_JavaLangString;
      paramvhv = i + "-" + paramvhv.c;
      long l1 = vht.a.parse(str).getTime() / 1000L;
      long l2 = vht.a.parse(paramvhv).getTime() / 1000L;
      this.a = l1;
      this.b = l2;
      return;
      bool = false;
    }
  }
  
  public vjj(vhv paramvhv, Card paramCard, int paramInt)
  {
    super(paramvhv);
    boolean bool;
    int i;
    label48:
    int j;
    if (paramvhv.e == 6)
    {
      bool = true;
      yos.a(bool);
      this.c = paramvhv.jdField_a_of_type_JavaLangString;
      if (paramCard == null) {
        break label239;
      }
      i = (int)((paramCard.lBirthday & 0xFF00) >> 8);
      if (paramCard == null) {
        break label245;
      }
      j = (int)(paramCard.lBirthday & 0xFF);
      label63:
      if ((i <= 0) || (j <= 0)) {
        break label270;
      }
      if (i >= 10) {
        break label251;
      }
      paramCard = "0" + i;
      label101:
      if (j >= 10) {
        break label260;
      }
    }
    label260:
    for (String str = "0" + j;; str = String.valueOf(j))
    {
      paramCard = paramInt + "-" + paramCard + "-" + str + " " + paramvhv.jdField_b_of_type_JavaLangString;
      paramCard = vht.a.parse(paramCard);
      long l1 = paramCard.getTime() / 1000L;
      long l2 = paramCard.getTime() / 1000L;
      long l3 = paramvhv.jdField_b_of_type_Int * 60 * 60;
      this.a = l1;
      this.b = (l2 + l3);
      return;
      bool = false;
      break;
      label239:
      i = 0;
      break label48;
      label245:
      j = 0;
      break label63;
      label251:
      paramCard = String.valueOf(i);
      break label101;
    }
    label270:
    this.a = 0L;
    this.b = 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TimeSplitConfig =[");
    localStringBuilder.append(" mStartTime=").append(this.a);
    localStringBuilder.append(" mEndTime=").append(this.b);
    localStringBuilder.append(" mAlbumName=").append(this.c);
    localStringBuilder.append("] ");
    return localStringBuilder.toString() + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjj
 * JD-Core Version:    0.7.0.1
 */