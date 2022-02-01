import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class qxl
  extends qxn
{
  public qxo a;
  protected Handler bl;
  private String mKey = "SerialStepExecutor";
  private ConcurrentLinkedQueue<qxo> p = new ConcurrentLinkedQueue();
  public Object param;
  private volatile int state = 0;
  
  public qxl(Handler paramHandler)
  {
    this.bl = paramHandler;
  }
  
  private void brt()
  {
    if (this.state == 2) {
      return;
    }
    this.bl.post(new SerialStepExecutor.1(this));
  }
  
  public qxl a(qxn.a parama)
  {
    this.jdField_a_of_type_Qxn$a = parama;
    return this;
  }
  
  public qxl a(qxn.b paramb)
  {
    this.jdField_a_of_type_Qxn$b = paramb;
    return this;
  }
  
  public qxl a(qxo paramqxo)
  {
    ram.b("Q.qqstory.home.SerialStepExecutor", "add Step:%s", paramqxo.getKey());
    this.p.offer(paramqxo);
    return this;
  }
  
  public void dump() {}
  
  public void e(ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_Qxn$b != null) {
      this.jdField_a_of_type_Qxn$b.e(paramErrorMessage);
    }
    if (this.jdField_a_of_type_Qxo.KH())
    {
      this.param = this.jdField_a_of_type_Qxo.D();
      if (this.param == null) {
        ram.e("Q.qqstory.home.SerialStepExecutor", "error step:" + this.jdField_a_of_type_Qxo.getKey() + ",return null result");
      }
      brt();
      return;
    }
    reset();
  }
  
  public String getKey()
  {
    return this.mKey;
  }
  
  public void reset()
  {
    try
    {
      this.state = 2;
      ram.d("Q.qqstory.home.SerialStepExecutor", "reset");
      if (this.jdField_a_of_type_Qxo != null)
      {
        this.jdField_a_of_type_Qxo.reset();
        this.jdField_a_of_type_Qxo.a(null);
        this.jdField_a_of_type_Qxo.a(null);
      }
      this.p.clear();
      this.bl.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Qxn$b = null;
      this.jdField_a_of_type_Qxn$a = null;
      return;
    }
    finally {}
  }
  
  public void run()
  {
    try
    {
      this.state = 1;
      brt();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void si(String paramString)
  {
    try
    {
      this.param = this.jdField_a_of_type_Qxo.D();
      if (this.param == null) {
        ram.e("Q.qqstory.home.SerialStepExecutor", "done step:" + this.jdField_a_of_type_Qxo.getKey() + ",return null result");
      }
      brt();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxl
 * JD-Core Version:    0.7.0.1
 */