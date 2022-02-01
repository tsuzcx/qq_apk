import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class afrq
{
  public boolean cax;
  public boolean cay;
  public MessageRecord h;
  public boolean isSelected;
  
  public afrq(MessageRecord paramMessageRecord)
  {
    this.h = paramMessageRecord;
    this.cax = (paramMessageRecord instanceof MessageForPic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrq
 * JD-Core Version:    0.7.0.1
 */