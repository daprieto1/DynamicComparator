package edu.uniandes.dynamiccomparator.Controllers;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.uniandes.dynamiccomparator.DynamicComparator;
import edu.uniandes.dynamiccomparator.Models.CompareVersionInput;
import edu.uniandes.dynamiccomparator.Tools.Tools;

@RestController
public class DynamicComparatorController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(method = RequestMethod.POST, value = "/compare", produces = { "application/JSON" }, consumes = {"application/JSON" })
	public CompareVersionInput greeting(@RequestBody CompareVersionInput input) throws IOException {
		DynamicComparator.execute(input);
		return input;
	}
}
