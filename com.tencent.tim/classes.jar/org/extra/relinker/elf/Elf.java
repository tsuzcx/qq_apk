package org.extra.relinker.elf;

import java.io.IOException;

public abstract interface Elf
{
  public static abstract class DynamicStructure
  {
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public long tag;
    public long val;
  }
  
  public static abstract class Header
  {
    public static final int ELFCLASS32 = 1;
    public static final int ELFCLASS64 = 2;
    public static final int ELFDATA2MSB = 2;
    public boolean bigEndian;
    public int phentsize;
    public int phnum;
    public long phoff;
    public int shentsize;
    public int shnum;
    public long shoff;
    public int shstrndx;
    public int type;
    
    public abstract Elf.DynamicStructure getDynamicStructure(long paramLong, int paramInt)
      throws IOException;
    
    public abstract Elf.ProgramHeader getProgramHeader(long paramLong)
      throws IOException;
    
    public abstract Elf.SectionHeader getSectionHeader(int paramInt)
      throws IOException;
  }
  
  public static abstract class ProgramHeader
  {
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;
    public long memsz;
    public long offset;
    public long type;
    public long vaddr;
  }
  
  public static abstract class SectionHeader
  {
    public long info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.extra.relinker.elf.Elf
 * JD-Core Version:    0.7.0.1
 */