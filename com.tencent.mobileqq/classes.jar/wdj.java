import com.tencent.mobileqq.data.Card;
import java.text.DateFormat;
import java.util.Date;

public class wdj
  extends wdi
{
  public long a;
  public long b;
  public String c;
  
  public wdj(wbu paramwbu, int paramInt)
  {
    super(paramwbu);
    if (paramwbu.e == 1) {}
    for (;;)
    {
      zkb.a(bool);
      this.c = paramwbu.jdField_a_of_type_JavaLangString;
      int i = paramInt;
      if (paramInt == 0) {
        i = paramwbu.jdField_a_of_type_Int;
      }
      String str = i + "-" + paramwbu.jdField_b_of_type_JavaLangString;
      paramwbu = i + "-" + paramwbu.c;
      long l1 = wbs.a.parse(str).getTime() / 1000L;
      long l2 = wbs.a.parse(paramwbu).getTime() / 1000L;
      this.a = l1;
      this.b = l2;
      return;
      bool = false;
    }
  }
  
  public wdj(wbu paramwbu, Card paramCard, int paramInt)
  {
    super(paramwbu);
    boolean bool;
    int i;
    label48:
    int j;
    if (paramwbu.e == 6)
    {
      bool = true;
      zkb.a(bool);
      this.c = paramwbu.jdField_a_of_type_JavaLangString;
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
      paramCard = paramInt + "-" + paramCard + "-" + str + " " + paramwbu.jdField_b_of_type_JavaLangString;
      paramCard = wbs.a.parse(paramCard);
      long l1 = paramCard.getTime() / 1000L;
      long l2 = paramCard.getTime() / 1000L;
      long l3 = paramwbu.jdField_b_of_type_Int * 60 * 60;
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
 * Qualified Name:     wdj
 * JD-Core Version:    0.7.0.1
 */