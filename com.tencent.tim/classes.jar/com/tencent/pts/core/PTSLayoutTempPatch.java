package com.tencent.pts.core;

import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSAnimationUtil.AnimationInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PTSLayoutTempPatch
{
  public static final int PTS_LAYOUT_PATCH_INSERT_CHILD = 2;
  public static final int PTS_LAYOUT_PATCH_MODIFY = 1;
  public static final int PTS_LAYOUT_PATCH_NONE = 0;
  public static final int PTS_LAYOUT_PATCH_REMOVE_CHILD = 4;
  public static final int PTS_LAYOUT_PATCH_REORDER_CHILD = 8;
  public List<PTSAnimationSet> animationNodeList = new ArrayList();
  public int layoutPatchType;
  public List<PTSNodeInfoInsert> newNodeInfoList = new ArrayList();
  public PTSNodeInfo nodeInfo;
  public List<Integer> removeNodeIDList = new ArrayList();
  
  static void applyLayoutTempPatchList(List<PTSLayoutTempPatch> paramList, PTSAppInstance paramPTSAppInstance)
  {
    if ((paramPTSAppInstance == null) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject1 = (PTSLayoutTempPatch)paramList.get(i);
      Object localObject2;
      Object localObject3;
      if (((((PTSLayoutTempPatch)localObject1).layoutPatchType & 0x2) > 0) && (((PTSLayoutTempPatch)localObject1).newNodeInfoList != null))
      {
        localObject2 = ((PTSLayoutTempPatch)localObject1).newNodeInfoList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (PTSNodeInfoInsert)((Iterator)localObject2).next();
          paramPTSAppInstance.getRootNode().insert(((PTSNodeInfoInsert)localObject3).nodeInfo, ((PTSNodeInfoInsert)localObject3).insertIndex);
        }
      }
      if (((((PTSLayoutTempPatch)localObject1).layoutPatchType & 0x4) > 0) && (((PTSLayoutTempPatch)localObject1).removeNodeIDList != null))
      {
        localObject2 = ((PTSLayoutTempPatch)localObject1).removeNodeIDList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Integer)((Iterator)localObject2).next();
          paramPTSAppInstance.getRootNode().remove(((Integer)localObject3).intValue());
        }
      }
      if ((((PTSLayoutTempPatch)localObject1).animationNodeList != null) && (!((PTSLayoutTempPatch)localObject1).animationNodeList.isEmpty())) {
        localObject1 = ((PTSLayoutTempPatch)localObject1).animationNodeList.iterator();
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PTSAnimationSet)((Iterator)localObject1).next();
        paramPTSAppInstance.getRootNode().animation(((PTSAnimationSet)localObject2).nodeInfo, ((PTSAnimationSet)localObject2).animationInfo);
        continue;
        if (((((PTSLayoutTempPatch)localObject1).layoutPatchType & 0x1) > 0) && (((PTSLayoutTempPatch)localObject1).nodeInfo != null)) {
          paramPTSAppInstance.getRootNode().modify(((PTSLayoutTempPatch)localObject1).nodeInfo);
        }
      }
      i += 1;
    }
    paramPTSAppInstance.getRootNode().onLayoutTempPatchFinished();
  }
  
  public void appendAnimation(PTSNodeInfo paramPTSNodeInfo, PTSAnimationUtil.AnimationInfo paramAnimationInfo)
  {
    PTSAnimationSet localPTSAnimationSet = new PTSAnimationSet();
    PTSAnimationSet.access$002(localPTSAnimationSet, paramPTSNodeInfo);
    PTSAnimationSet.access$102(localPTSAnimationSet, paramAnimationInfo);
    this.animationNodeList.add(localPTSAnimationSet);
  }
  
  public void appendNewNodeInfo(PTSNodeInfo paramPTSNodeInfo, int paramInt)
  {
    PTSNodeInfoInsert localPTSNodeInfoInsert = new PTSNodeInfoInsert();
    localPTSNodeInfoInsert.nodeInfo = paramPTSNodeInfo;
    localPTSNodeInfoInsert.insertIndex = paramInt;
    this.newNodeInfoList.add(localPTSNodeInfoInsert);
  }
  
  public void appendRemoveNodeID(int paramInt)
  {
    this.removeNodeIDList.add(Integer.valueOf(paramInt));
  }
  
  public void setLayoutPatchType(int paramInt)
  {
    this.layoutPatchType = paramInt;
  }
  
  public void setNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.nodeInfo = paramPTSNodeInfo;
  }
  
  public static class PTSAnimationSet
  {
    private PTSAnimationUtil.AnimationInfo animationInfo;
    private PTSNodeInfo nodeInfo;
  }
  
  public static class PTSNodeInfoInsert
  {
    public int insertIndex;
    public PTSNodeInfo nodeInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSLayoutTempPatch
 * JD-Core Version:    0.7.0.1
 */