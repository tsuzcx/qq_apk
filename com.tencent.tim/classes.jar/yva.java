import android.graphics.Color;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.Color;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.Label;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.RecommendPerson;

public class yva
{
  public int age;
  public int gender;
  public ArrayList<RecommendLabel> lables;
  public String name;
  public String reason;
  public String uin;
  
  public static yva a(oidb_0xe3b.RecommendPerson paramRecommendPerson)
  {
    int j = -1;
    yva localyva = new yva();
    localyva.uin = String.valueOf(paramRecommendPerson.uint64_uin.get());
    Object localObject;
    label74:
    int i;
    label98:
    oidb_0xe3b.Label localLabel;
    label173:
    RecommendLabel localRecommendLabel;
    if (paramRecommendPerson.bytes_title.has())
    {
      localObject = paramRecommendPerson.bytes_title.get().toStringUtf8();
      localyva.name = ((String)localObject);
      if (!paramRecommendPerson.bytes_reason.has()) {
        break label404;
      }
      localObject = paramRecommendPerson.bytes_reason.get().toStringUtf8();
      localyva.reason = ((String)localObject);
      if (!paramRecommendPerson.uint32_age.has()) {
        break label410;
      }
      i = paramRecommendPerson.uint32_age.get();
      localyva.age = i;
      i = j;
      if (paramRecommendPerson.uint32_gender.has()) {
        i = paramRecommendPerson.uint32_gender.get();
      }
      localyva.gender = i;
      if (!paramRecommendPerson.rpt_msg_label.has()) {
        break label421;
      }
      paramRecommendPerson = paramRecommendPerson.rpt_msg_label.get();
      localyva.lables = new ArrayList(paramRecommendPerson.size());
      localObject = paramRecommendPerson.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label421;
      }
      localLabel = (oidb_0xe3b.Label)((Iterator)localObject).next();
      localRecommendLabel = new RecommendLabel();
      if (!localLabel.bytes_name.has()) {
        break label415;
      }
    }
    label404:
    label410:
    label415:
    for (paramRecommendPerson = localLabel.bytes_name.get().toStringUtf8();; paramRecommendPerson = "")
    {
      localRecommendLabel.bytes_name = paramRecommendPerson;
      localRecommendLabel.uint32_label_type = localLabel.uint32_label_type.get();
      if (localLabel.text_color.has()) {
        localRecommendLabel.text_color = Color.rgb(((oidb_0xe3b.Color)localLabel.text_color.get()).uint32_r.get(), ((oidb_0xe3b.Color)localLabel.text_color.get()).uint32_g.get(), ((oidb_0xe3b.Color)localLabel.text_color.get()).uint32_b.get());
      }
      if (localLabel.edging_color.has()) {
        localRecommendLabel.edging_color = Color.rgb(((oidb_0xe3b.Color)localLabel.edging_color.get()).uint32_r.get(), ((oidb_0xe3b.Color)localLabel.edging_color.get()).uint32_g.get(), ((oidb_0xe3b.Color)localLabel.edging_color.get()).uint32_b.get());
      }
      localyva.lables.add(localRecommendLabel);
      break label173;
      localObject = "";
      break;
      localObject = "";
      break label74;
      i = -1;
      break label98;
    }
    label421:
    return localyva;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yva
 * JD-Core Version:    0.7.0.1
 */