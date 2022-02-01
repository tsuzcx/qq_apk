package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class BatchGetSimilarGroupidRsp
  extends JceStruct
{
  static Map<String, Integer> cache_fails;
  static Map<String, String> cache_new_groupids;
  static Map<String, ArrayList<cluster_search_result>> cache_results = new HashMap();
  public Map<String, Integer> fails;
  public String msg = "";
  public Map<String, String> new_groupids;
  public Map<String, ArrayList<cluster_search_result>> results;
  public int ret;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cluster_search_result());
    cache_results.put("", localArrayList);
    cache_fails = new HashMap();
    cache_fails.put("", Integer.valueOf(0));
    cache_new_groupids = new HashMap();
    cache_new_groupids.put("", "");
  }
  
  public BatchGetSimilarGroupidRsp() {}
  
  public BatchGetSimilarGroupidRsp(int paramInt, String paramString, Map<String, ArrayList<cluster_search_result>> paramMap, Map<String, Integer> paramMap1, Map<String, String> paramMap2)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.results = paramMap;
    this.fails = paramMap1;
    this.new_groupids = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.results = ((Map)paramJceInputStream.read(cache_results, 2, false));
    this.fails = ((Map)paramJceInputStream.read(cache_fails, 3, false));
    this.new_groupids = ((Map)paramJceInputStream.read(cache_new_groupids, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.results != null) {
      paramJceOutputStream.write(this.results, 2);
    }
    if (this.fails != null) {
      paramJceOutputStream.write(this.fails, 3);
    }
    if (this.new_groupids != null) {
      paramJceOutputStream.write(this.new_groupids, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.BatchGetSimilarGroupidRsp
 * JD-Core Version:    0.7.0.1
 */