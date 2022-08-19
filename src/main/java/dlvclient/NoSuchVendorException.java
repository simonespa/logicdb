package dlvclient;

public class NoSuchVendorException extends Exception {

	private static final long serialVersionUID = -210492244871750527L;

	@Override
	public String getMessage() {
		return "Null is not a valid vendor object.";
	}

}
