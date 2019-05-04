//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.2
//
// <auto-generated>
//
// Generated from file `bank.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Bank;

public class InvalidIDException extends BaseException
{
    public InvalidIDException()
    {
        super();
        this.id = "";
    }

    public InvalidIDException(Throwable cause)
    {
        super(cause);
        this.id = "";
    }

    public InvalidIDException(String msg, String id)
    {
        super(msg);
        this.id = id;
    }

    public InvalidIDException(String msg, String id, Throwable cause)
    {
        super(msg, cause);
        this.id = id;
    }

    public String ice_id()
    {
        return "::Bank::InvalidIDException";
    }

    public String id;

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::Bank::InvalidIDException", -1, false);
        ostr_.writeString(id);
        ostr_.endSlice();
        super._writeImpl(ostr_);
    }

    /** @hidden */
    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        id = istr_.readString();
        istr_.endSlice();
        super._readImpl(istr_);
    }

    /** @hidden */
    public static final long serialVersionUID = -1807951412L;
}
