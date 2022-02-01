import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class angi
  implements Comparable<angi>
{
  public angd.b a;
  public long akX;
  public anfu b;
  public anfw b;
  public angu c;
  public boolean cFr;
  public String[] cJ;
  public String cdE = akxq.xP();
  public angt d;
  public int dFl;
  public int dFq = -1;
  public int dFr;
  public int dFs;
  public int dFt;
  public String logTag;
  public MessageForShortVideo o;
  public int priority = 201;
  public ArrayList<anfw> yu;
  
  public int a(angi paramangi)
  {
    if (this.priority < paramangi.priority) {
      return -1;
    }
    if (this.priority > paramangi.priority) {
      return 1;
    }
    return 0;
  }
  
  public void b(anfw paramanfw)
  {
    if (paramanfw == null)
    {
      akxe.M("PIC_TAG_ERROR", this.cdE, "bindReqObj", "forwardInfo == null");
      return;
    }
    paramanfw.dFl = this.dFl;
    this.jdField_b_of_type_Anfw = paramanfw;
    this.logTag = akxe.l(this.jdField_b_of_type_Anfw.uinType, 2, 20);
  }
  
  public void b(angu paramangu)
  {
    this.c = paramangu;
  }
  
  public void c(anfu paramanfu)
  {
    int j = 6;
    if (paramanfu == null)
    {
      akxe.M("PIC_TAG_ERROR", this.cdE, "bindReqObj", "downInfo == null");
      return;
    }
    paramanfu.dFl = this.dFl;
    this.jdField_b_of_type_Anfu = paramanfu;
    int i;
    if (paramanfu.fileType == 1002) {
      i = 7;
    }
    for (;;)
    {
      this.logTag = akxe.l(this.jdField_b_of_type_Anfu.uinType, 0, i);
      return;
      if (paramanfu.fileType == 1006)
      {
        i = 18;
      }
      else if (paramanfu.fileType == 1004)
      {
        i = 16;
      }
      else
      {
        i = j;
        if (paramanfu.fileType != 1001) {
          if (paramanfu.fileType == 1005)
          {
            i = 17;
          }
          else
          {
            i = j;
            if (paramanfu.fileType == 1003) {
              i = 9;
            }
          }
        }
      }
    }
  }
  
  public void c(angt paramangt)
  {
    int i = 6;
    if (paramangt == null)
    {
      akxe.M("PIC_TAG_ERROR", this.cdE, "bindReqObj", "upInfo == null");
      return;
    }
    paramangt.dFl = this.dFl;
    this.d = paramangt;
    if (paramangt.uinType == 0) {}
    for (;;)
    {
      this.logTag = akxe.l(this.d.uinType, 1, i);
      return;
      if (paramangt.uinType == 3000) {
        i = 17;
      } else if (paramangt.uinType == 1) {
        i = 9;
      }
    }
  }
  
  public void eF(ArrayList<anfw> paramArrayList)
  {
    this.yu = paramArrayList;
  }
  
  public void p(MessageForShortVideo paramMessageForShortVideo)
  {
    this.o = paramMessageForShortVideo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angi
 * JD-Core Version:    0.7.0.1
 */