import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ayun
  extends aygy
{
  private static final SparseArray<ayty> en = new SparseArray();
  axpr.a b;
  private Set<Integer> dG = new HashSet();
  
  static
  {
    en.put(3000, ayty.a(99, 1, 0, ayun.class));
    en.put(5, ayty.a(99, 3, 0, ayfw.class));
    en.put(6, ayty.a(99, 5, 0, ayfw.class));
    en.put(7, ayty.a(99, 7, 0, ayfw.class));
    en.put(2, ayty.a(99, 4, 0, axrg.class));
    en.put(30, ayty.a(99, 6, 0, ayeh.class));
    en.put(28, ayty.a(99, 9, 0, ayhz.class));
    en.put(29, ayty.a(99, 8, 0, ayeh.class));
    en.put(4001, ayty.a(99, 16, 0, ayeh.class));
    en.put(3005, ayty.a(99, 2, 0, ayun.class));
    en.put(3006, ayty.a(99, 15, 0, ayun.class));
    en.put(3002, ayty.a(99, 10, 1, ayun.class));
    en.put(3003, ayty.a(99, 10, 2, ayun.class));
    en.put(3001, ayty.a(99, 13, 0, ayun.class));
    en.put(3007, ayty.a(99, 12, 1, ayun.class));
    en.put(3008, ayty.a(99, 12, 2, ayun.class));
    en.put(3004, ayty.a(99, 14, 0, ayun.class));
    en.put(3009, ayty.a(99, 11, 0, ayun.class));
  }
  
  public ayun(@NonNull aygz paramaygz)
  {
    super(paramaygz);
    this.jdField_b_of_type_Axpr$a = new ayuo(this);
  }
  
  private void eTM()
  {
    Iterator localIterator = this.jdField_b_of_type_Aygz.getParts().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (aygy)localIterator.next();
      Object localObject2;
      if ((localObject1 instanceof ayfw))
      {
        localObject2 = (ayfw)localObject1;
        if (!((ayfw)localObject2).a().isEmpty())
        {
          if (!((ayfw)localObject2).a().a().isEmpty()) {
            this.dG.add(Integer.valueOf(5));
          }
          if (!((ayfw)localObject2).a().a().isEmpty()) {
            this.dG.add(Integer.valueOf(1));
          }
          if (!((ayfw)localObject2).a().a().isEmpty()) {
            this.dG.add(Integer.valueOf(3));
          }
        }
      }
      if ((localObject1 instanceof ayeh))
      {
        localObject1 = (ayeh)localObject1;
        localObject2 = new JSONObject();
        ((ayeh)localObject1).cm((JSONObject)localObject2);
        if (((JSONObject)localObject2).has(ayeh.cWP))
        {
          try
          {
            localObject1 = ((JSONObject)localObject2).getJSONObject(ayeh.cWP);
            if (!((JSONObject)localObject1).has("comboItem")) {
              break label237;
            }
            QZLog.d("QzoneEditVideoPartRepor", 2, new Object[] { "buildReportExtraReserves", " has combo item" });
            this.dG.add(Integer.valueOf(4));
          }
          catch (JSONException localJSONException)
          {
            QZLog.d("QzoneEditVideoPartRepor", 2, "buildReportExtraReserves", localJSONException);
          }
          continue;
          label237:
          if (localJSONException.has("musicItem"))
          {
            QZLog.d("QzoneEditVideoPartRepor", 2, new Object[] { "buildReportExtraReserves", " has music item" });
            this.dG.add(Integer.valueOf(2));
          }
          else if (localJSONException.has("filterItem"))
          {
            QZLog.d("QzoneEditVideoPartRepor", 2, new Object[] { "buildReportExtraReserves", " has filter item" });
          }
        }
      }
    }
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    if (paramayqb.g.saveMode != 0) {
      this.dG.add(Integer.valueOf(7));
    }
    eTM();
    p(3006, null);
  }
  
  protected boolean e(Message paramMessage)
  {
    if ((paramMessage.what == 9) && (paramMessage.arg1 == 28)) {
      p(paramMessage.arg1, null);
    }
    return super.e(paramMessage);
  }
  
  public void onCreate()
  {
    super.onCreate();
    p(3000, null);
    ((axpr)axov.a(5)).a(this.jdField_b_of_type_Axpr$a);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((axpr)axov.a(5)).b(this.jdField_b_of_type_Axpr$a);
  }
  
  public void p(int paramInt, Object paramObject)
  {
    super.p(paramInt, paramObject);
    paramObject = (ayty)en.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3006) {
        paramObject.v(this.dG);
      }
      paramObject.eTE();
      return;
    }
    QZLog.w("QzoneEditVideoPartRepor", 2, new Object[] { "editVideoStateChanged we are not interested at this edit state " + paramInt });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayun
 * JD-Core Version:    0.7.0.1
 */