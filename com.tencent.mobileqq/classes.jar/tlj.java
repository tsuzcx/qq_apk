import com.tencent.biz.qqstory.network.pb.qqstory_struct.DateVideoCollectionID;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class tlj
{
  public int a;
  public int b;
  
  public qqstory_struct.DateVideoCollectionID a()
  {
    qqstory_struct.DateVideoCollectionID localDateVideoCollectionID = new qqstory_struct.DateVideoCollectionID();
    localDateVideoCollectionID.collection_id.set(this.a);
    localDateVideoCollectionID.collection_type.set(this.b);
    return localDateVideoCollectionID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlj
 * JD-Core Version:    0.7.0.1
 */