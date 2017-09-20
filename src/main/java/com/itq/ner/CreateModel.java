/**
 * 
 */
package com.itq.ner;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import opennlp.addons.modelbuilder.DefaultModelBuilderUtil;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

/**
 * @author A039883
 *
 */
public class CreateModel {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		String modelType = args[0];

		/**
	     * establish a file to put sentences in
	     */
	    File sentences = new File("classes/models/"+modelType+"/sentences.txt");

	    /**
	     * establish a file to put your NER hits in (the ones you want to keep based on prob)
	     */
	    File knownEntities = new File("classes/models/"+modelType+"/knownentities.txt");

	    /**
	     * establish a BLACKLIST file to put your bad NER hits in (also can be based on prob)
	     */
	    File blacklistedentities = new File("classes/models/"+modelType+"/blentities.txt");

	    /**
	     * establish a file to write your annotated sentences to
	     */
	    File annotatedSentences = new File("classes/models/"+modelType+"/annotatedSentences.txt");

	    /**
	     * establish a file to write your model to
	     */
	    File theModel = new File("classes/models/"+modelType+"/itq-"+modelType+"-model.bin");

	    /**
	     * THIS IS WHERE THE ADDON IS GOING TO USE THE FILES (AS IS) TO CREATE A NEW MODEL. YOU SHOULD NOT HAVE TO RUN THE FIRST PART AGAIN AFTER THIS RUNS, JUST NOW PLAY WITH THE
	     * KNOWN ENTITIES AND BLACKLIST FILES AND RUN THE METHOD BELOW AGAIN UNTIL YOU GET SOME DECENT RESULTS (A DECENT MODEL OUT OF IT).
	     */
	    DefaultModelBuilderUtil.generateModel(sentences, knownEntities, blacklistedentities, theModel, annotatedSentences, modelType, 3);
	}
}
