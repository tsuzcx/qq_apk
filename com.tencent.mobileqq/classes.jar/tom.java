import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.POIPosterData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;

public class tom
  extends syq
{
  public final ArrayList<teh> a = new ArrayList();
  
  public tom(qqstory_service.RspGetPOIPosters paramRspGetPOIPosters)
  {
    a(paramRspGetPOIPosters);
  }
  
  private void a(qqstory_service.RspGetPOIPosters paramRspGetPOIPosters)
  {
    int i = 0;
    while (i < paramRspGetPOIPosters.poi_posters.size())
    {
      Object localObject = (qqstory_struct.POIPosterData)paramRspGetPOIPosters.poi_posters.get(i);
      localObject = new teh(((qqstory_struct.POIPosterData)localObject).poster_name.get().toStringUtf8(), ((qqstory_struct.POIPosterData)localObject).name.get().toStringUtf8(), ((qqstory_struct.POIPosterData)localObject).thumb_url.get().toStringUtf8(), ((qqstory_struct.POIPosterData)localObject).poster_url.get().toStringUtf8(), ((qqstory_struct.POIPosterData)localObject).poster_json_layout_desc.get().toStringUtf8());
      this.a.add(localObject);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tom
 * JD-Core Version:    0.7.0.1
 */