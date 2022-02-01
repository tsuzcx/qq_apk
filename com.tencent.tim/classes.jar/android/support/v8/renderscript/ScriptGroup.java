package android.support.v8.renderscript;

import java.util.ArrayList;

public class ScriptGroup
  extends BaseObj
{
  IO[] mInputs;
  IO[] mOutputs;
  
  ScriptGroup(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public void execute()
  {
    this.mRS.nScriptGroupExecute(getID(this.mRS));
  }
  
  public void setInput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    int i = 0;
    while (i < this.mInputs.length)
    {
      if (this.mInputs[i].mKID == paramKernelID)
      {
        this.mInputs[i].mAllocation = paramAllocation;
        this.mRS.nScriptGroupSetInput(getID(this.mRS), paramKernelID.getID(this.mRS), this.mRS.safeID(paramAllocation));
        return;
      }
      i += 1;
    }
    throw new RSIllegalArgumentException("Script not found");
  }
  
  public void setOutput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    int i = 0;
    while (i < this.mOutputs.length)
    {
      if (this.mOutputs[i].mKID == paramKernelID)
      {
        this.mOutputs[i].mAllocation = paramAllocation;
        this.mRS.nScriptGroupSetOutput(getID(this.mRS), paramKernelID.getID(this.mRS), this.mRS.safeID(paramAllocation));
        return;
      }
      i += 1;
    }
    throw new RSIllegalArgumentException("Script not found");
  }
  
  public static final class Builder
  {
    private int mKernelCount;
    private ArrayList<ScriptGroup.ConnectLine> mLines = new ArrayList();
    private ArrayList<ScriptGroup.Node> mNodes = new ArrayList();
    private RenderScript mRS;
    private ScriptGroupThunker.Builder mT;
    
    public Builder(RenderScript paramRenderScript)
    {
      if (RenderScript.isNative) {
        this.mT = new ScriptGroupThunker.Builder(paramRenderScript);
      }
      this.mRS = paramRenderScript;
    }
    
    private ScriptGroup.Node findNode(Script.KernelID paramKernelID)
    {
      int i = 0;
      while (i < this.mNodes.size())
      {
        ScriptGroup.Node localNode = (ScriptGroup.Node)this.mNodes.get(i);
        int j = 0;
        while (j < localNode.mKernels.size())
        {
          if (paramKernelID == localNode.mKernels.get(j)) {
            return localNode;
          }
          j += 1;
        }
        i += 1;
      }
      return null;
    }
    
    private ScriptGroup.Node findNode(Script paramScript)
    {
      int i = 0;
      while (i < this.mNodes.size())
      {
        if (paramScript == ((ScriptGroup.Node)this.mNodes.get(i)).mScript) {
          return (ScriptGroup.Node)this.mNodes.get(i);
        }
        i += 1;
      }
      return null;
    }
    
    private void mergeDAGs(int paramInt1, int paramInt2)
    {
      int i = 0;
      while (i < this.mNodes.size())
      {
        if (((ScriptGroup.Node)this.mNodes.get(i)).dagNumber == paramInt2) {
          ((ScriptGroup.Node)this.mNodes.get(i)).dagNumber = paramInt1;
        }
        i += 1;
      }
    }
    
    private void validateCycle(ScriptGroup.Node paramNode1, ScriptGroup.Node paramNode2)
    {
      int i = 0;
      while (i < paramNode1.mOutputs.size())
      {
        Object localObject = (ScriptGroup.ConnectLine)paramNode1.mOutputs.get(i);
        if (((ScriptGroup.ConnectLine)localObject).mToK != null)
        {
          ScriptGroup.Node localNode = findNode(((ScriptGroup.ConnectLine)localObject).mToK.mScript);
          if (localNode.equals(paramNode2)) {
            throw new RSInvalidStateException("Loops in group not allowed.");
          }
          validateCycle(localNode, paramNode2);
        }
        if (((ScriptGroup.ConnectLine)localObject).mToF != null)
        {
          localObject = findNode(((ScriptGroup.ConnectLine)localObject).mToF.mScript);
          if (localObject.equals(paramNode2)) {
            throw new RSInvalidStateException("Loops in group not allowed.");
          }
          validateCycle((ScriptGroup.Node)localObject, paramNode2);
        }
        i += 1;
      }
    }
    
    private void validateDAG()
    {
      int j = 0;
      int i = 0;
      while (i < this.mNodes.size())
      {
        ScriptGroup.Node localNode = (ScriptGroup.Node)this.mNodes.get(i);
        if (localNode.mInputs.size() == 0)
        {
          if ((localNode.mOutputs.size() == 0) && (this.mNodes.size() > 1)) {
            throw new RSInvalidStateException("Groups cannot contain unconnected scripts");
          }
          validateDAGRecurse(localNode, i + 1);
        }
        i += 1;
      }
      int k = ((ScriptGroup.Node)this.mNodes.get(0)).dagNumber;
      i = j;
      while (i < this.mNodes.size())
      {
        if (((ScriptGroup.Node)this.mNodes.get(i)).dagNumber != k) {
          throw new RSInvalidStateException("Multiple DAGs in group not allowed.");
        }
        i += 1;
      }
    }
    
    private void validateDAGRecurse(ScriptGroup.Node paramNode, int paramInt)
    {
      if ((paramNode.dagNumber != 0) && (paramNode.dagNumber != paramInt)) {
        mergeDAGs(paramNode.dagNumber, paramInt);
      }
      for (;;)
      {
        return;
        paramNode.dagNumber = paramInt;
        int i = 0;
        while (i < paramNode.mOutputs.size())
        {
          ScriptGroup.ConnectLine localConnectLine = (ScriptGroup.ConnectLine)paramNode.mOutputs.get(i);
          if (localConnectLine.mToK != null) {
            validateDAGRecurse(findNode(localConnectLine.mToK.mScript), paramInt);
          }
          if (localConnectLine.mToF != null) {
            validateDAGRecurse(findNode(localConnectLine.mToF.mScript), paramInt);
          }
          i += 1;
        }
      }
    }
    
    public Builder addConnection(Type paramType, Script.KernelID paramKernelID, Script.FieldID paramFieldID)
    {
      if (this.mT != null)
      {
        this.mT.addConnection(paramType, paramKernelID, paramFieldID);
        return this;
      }
      ScriptGroup.Node localNode1 = findNode(paramKernelID);
      if (localNode1 == null) {
        throw new RSInvalidStateException("From script not found.");
      }
      ScriptGroup.Node localNode2 = findNode(paramFieldID.mScript);
      if (localNode2 == null) {
        throw new RSInvalidStateException("To script not found.");
      }
      ScriptGroup.ConnectLine localConnectLine = new ScriptGroup.ConnectLine(paramType, paramKernelID, paramFieldID);
      this.mLines.add(new ScriptGroup.ConnectLine(paramType, paramKernelID, paramFieldID));
      localNode1.mOutputs.add(localConnectLine);
      localNode2.mInputs.add(localConnectLine);
      validateCycle(localNode1, localNode1);
      return this;
    }
    
    public Builder addConnection(Type paramType, Script.KernelID paramKernelID1, Script.KernelID paramKernelID2)
    {
      if (this.mT != null)
      {
        this.mT.addConnection(paramType, paramKernelID1, paramKernelID2);
        return this;
      }
      ScriptGroup.Node localNode1 = findNode(paramKernelID1);
      if (localNode1 == null) {
        throw new RSInvalidStateException("From script not found.");
      }
      ScriptGroup.Node localNode2 = findNode(paramKernelID2);
      if (localNode2 == null) {
        throw new RSInvalidStateException("To script not found.");
      }
      ScriptGroup.ConnectLine localConnectLine = new ScriptGroup.ConnectLine(paramType, paramKernelID1, paramKernelID2);
      this.mLines.add(new ScriptGroup.ConnectLine(paramType, paramKernelID1, paramKernelID2));
      localNode1.mOutputs.add(localConnectLine);
      localNode2.mInputs.add(localConnectLine);
      validateCycle(localNode1, localNode1);
      return this;
    }
    
    public Builder addKernel(Script.KernelID paramKernelID)
    {
      if (this.mT != null) {
        this.mT.addKernel(paramKernelID);
      }
      do
      {
        return this;
        if (this.mLines.size() != 0) {
          throw new RSInvalidStateException("Kernels may not be added once connections exist.");
        }
      } while (findNode(paramKernelID) != null);
      this.mKernelCount += 1;
      ScriptGroup.Node localNode2 = findNode(paramKernelID.mScript);
      ScriptGroup.Node localNode1 = localNode2;
      if (localNode2 == null)
      {
        localNode1 = new ScriptGroup.Node(paramKernelID.mScript);
        this.mNodes.add(localNode1);
      }
      localNode1.mKernels.add(paramKernelID);
      return this;
    }
    
    public ScriptGroup create()
    {
      int i2 = 0;
      if (this.mT != null) {
        return this.mT.create();
      }
      if (this.mNodes.size() == 0) {
        throw new RSInvalidStateException("Empty script groups are not allowed");
      }
      int i = 0;
      while (i < this.mNodes.size())
      {
        ((ScriptGroup.Node)this.mNodes.get(i)).dagNumber = 0;
        i += 1;
      }
      validateDAG();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject1 = new int[this.mKernelCount];
      int j = 0;
      i = 0;
      while (j < this.mNodes.size())
      {
        localObject2 = (ScriptGroup.Node)this.mNodes.get(j);
        int k = 0;
        while (k < ((ScriptGroup.Node)localObject2).mKernels.size())
        {
          localObject3 = (Script.KernelID)((ScriptGroup.Node)localObject2).mKernels.get(k);
          localObject1[i] = ((Script.KernelID)localObject3).getID(this.mRS);
          int n = 0;
          int m = 0;
          while (n < ((ScriptGroup.Node)localObject2).mInputs.size())
          {
            if (((ScriptGroup.ConnectLine)((ScriptGroup.Node)localObject2).mInputs.get(n)).mToK == localObject3) {
              m = 1;
            }
            n += 1;
          }
          n = 0;
          int i1 = 0;
          while (n < ((ScriptGroup.Node)localObject2).mOutputs.size())
          {
            if (((ScriptGroup.ConnectLine)((ScriptGroup.Node)localObject2).mOutputs.get(n)).mFrom == localObject3) {
              i1 = 1;
            }
            n += 1;
          }
          if (m == 0) {
            localArrayList1.add(new ScriptGroup.IO((Script.KernelID)localObject3));
          }
          if (i1 == 0) {
            localArrayList2.add(new ScriptGroup.IO((Script.KernelID)localObject3));
          }
          k += 1;
          i += 1;
        }
        j += 1;
      }
      if (i != this.mKernelCount) {
        throw new RSRuntimeException("Count mismatch, should not happen.");
      }
      Object localObject2 = new int[this.mLines.size()];
      Object localObject3 = new int[this.mLines.size()];
      int[] arrayOfInt1 = new int[this.mLines.size()];
      int[] arrayOfInt2 = new int[this.mLines.size()];
      i = 0;
      while (i < this.mLines.size())
      {
        ScriptGroup.ConnectLine localConnectLine = (ScriptGroup.ConnectLine)this.mLines.get(i);
        localObject2[i] = localConnectLine.mFrom.getID(this.mRS);
        if (localConnectLine.mToK != null) {
          localObject3[i] = localConnectLine.mToK.getID(this.mRS);
        }
        if (localConnectLine.mToF != null) {
          arrayOfInt1[i] = localConnectLine.mToF.getID(this.mRS);
        }
        arrayOfInt2[i] = localConnectLine.mAllocationType.getID(this.mRS);
        i += 1;
      }
      i = this.mRS.nScriptGroupCreate((int[])localObject1, (int[])localObject2, (int[])localObject3, arrayOfInt1, arrayOfInt2);
      if (i == 0) {
        throw new RSRuntimeException("Object creation error, should not happen.");
      }
      localObject1 = new ScriptGroup(i, this.mRS);
      ((ScriptGroup)localObject1).mOutputs = new ScriptGroup.IO[localArrayList2.size()];
      i = 0;
      while (i < localArrayList2.size())
      {
        ((ScriptGroup)localObject1).mOutputs[i] = ((ScriptGroup.IO)localArrayList2.get(i));
        i += 1;
      }
      ((ScriptGroup)localObject1).mInputs = new ScriptGroup.IO[localArrayList1.size()];
      i = i2;
      while (i < localArrayList1.size())
      {
        ((ScriptGroup)localObject1).mInputs[i] = ((ScriptGroup.IO)localArrayList1.get(i));
        i += 1;
      }
      return localObject1;
    }
  }
  
  static class ConnectLine
  {
    Type mAllocationType;
    Script.KernelID mFrom;
    Script.FieldID mToF;
    Script.KernelID mToK;
    
    ConnectLine(Type paramType, Script.KernelID paramKernelID, Script.FieldID paramFieldID)
    {
      this.mFrom = paramKernelID;
      this.mToF = paramFieldID;
      this.mAllocationType = paramType;
    }
    
    ConnectLine(Type paramType, Script.KernelID paramKernelID1, Script.KernelID paramKernelID2)
    {
      this.mFrom = paramKernelID1;
      this.mToK = paramKernelID2;
      this.mAllocationType = paramType;
    }
  }
  
  static class IO
  {
    Allocation mAllocation;
    Script.KernelID mKID;
    
    IO(Script.KernelID paramKernelID)
    {
      this.mKID = paramKernelID;
    }
  }
  
  static class Node
  {
    int dagNumber;
    ArrayList<ScriptGroup.ConnectLine> mInputs = new ArrayList();
    ArrayList<Script.KernelID> mKernels = new ArrayList();
    Node mNext;
    ArrayList<ScriptGroup.ConnectLine> mOutputs = new ArrayList();
    Script mScript;
    
    Node(Script paramScript)
    {
      this.mScript = paramScript;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptGroup
 * JD-Core Version:    0.7.0.1
 */