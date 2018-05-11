package io.github.nenodias.springgroovy.container;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyShell;
import groovy.lang.MetaClass;
import groovy.lang.Script;
import groovy.util.GroovyScriptEngine;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.groovy.control.CompilationFailedException;

public class ScriptingContainer {
    
    private static final Logger LOGGER = Logger.getLogger(ScriptingContainer.class);
    
    private Binding binding;
    private GroovyShell shell;

    public ScriptingContainer() {
        this.binding = new Binding();
        this.shell = new GroovyShell(binding);
    }
    
    public void put(String name, Object value){
        binding.setVariable(name, value);
    }
    
    public Object get(String name){
        return binding.getVariable(name);
    }

    public static void main(String[] args) {
        GroovyShell.main(args);
    }

    public void resetLoadedClasses() {
        shell.resetLoadedClasses();
    }

    public Binding getContext() {
        return shell.getContext();
    }

    public GroovyClassLoader getClassLoader() {
        return shell.getClassLoader();
    }

    public Object getProperty(String property) {
        return shell.getProperty(property);
    }

    public void setProperty(String property, Object newValue) {
        shell.setProperty(property, newValue);
    }

    public Object run(File scriptFile, List list) throws CompilationFailedException, IOException {
        return shell.run(scriptFile, list);
    }

    public Object run(String scriptText, String fileName, List list) throws CompilationFailedException {
        return shell.run(scriptText, fileName, list);
    }

    public Object run(File scriptFile, String[] args) throws CompilationFailedException, IOException {
        return shell.run(scriptFile, args);
    }

    public Object run(String scriptText, String fileName, String[] args) throws CompilationFailedException {
        return shell.run(scriptText, fileName, args);
    }

    public Object run(GroovyCodeSource source, List args) throws CompilationFailedException {
        return shell.run(source, args);
    }

    public Object run(GroovyCodeSource source, String[] args) throws CompilationFailedException {
        return shell.run(source, args);
    }

    public Object run(URI source, List args) throws CompilationFailedException, IOException {
        return shell.run(source, args);
    }
    

    public Object run(URI source, String[] args) throws CompilationFailedException, IOException {
        return shell.run(source, args);
    }
    
    public Object run(URL url) throws CompilationFailedException, IOException {
        URI uri = toURI(url);
        Script script = shell.parse(uri);
        return script.run();
    }
    
    public Object run(URL url, List args) throws CompilationFailedException, IOException {
        URI uri = toURI(url);
        return shell.run(uri, args);
    }

    public Object run(URL url, String[] args) throws CompilationFailedException, IOException {
        URI uri = toURI(url);
        return shell.run(uri, args);
    }

    public Object run(Reader in, String fileName, List list) throws CompilationFailedException {
        return shell.run(in, fileName, list);
    }

    public Object run(Reader in, String fileName, String[] args) throws CompilationFailedException {
        return shell.run(in, fileName, args);
    }

    public Object getVariable(String name) {
        return shell.getVariable(name);
    }

    public void setVariable(String name, Object value) {
        shell.setVariable(name, value);
    }

    public Object evaluate(GroovyCodeSource codeSource) throws CompilationFailedException {
        return shell.evaluate(codeSource);
    }

    public Object evaluate(String scriptText) throws CompilationFailedException {
        return shell.evaluate(scriptText);
    }

    public Object evaluate(String scriptText, String fileName) throws CompilationFailedException {
        return shell.evaluate(scriptText, fileName);
    }

    public Object evaluate(String scriptText, String fileName, String codeBase) throws CompilationFailedException {
        return shell.evaluate(scriptText, fileName, codeBase);
    }

    public Object evaluate(File file) throws CompilationFailedException, IOException {
        return shell.evaluate(file);
    }
    
    public Object evaluate(URL url) throws CompilationFailedException, IOException {
        URI uri = toURI(url);
        return shell.evaluate(uri);
    }

    public Object evaluate(URI uri) throws CompilationFailedException, IOException {
        return shell.evaluate(uri);
    }

    public Object evaluate(Reader in) throws CompilationFailedException {
        return shell.evaluate(in);
    }

    public Object evaluate(Reader in, String fileName) throws CompilationFailedException {
        return shell.evaluate(in, fileName);
    }

    public Script parse(Reader reader, String fileName) throws CompilationFailedException {
        return shell.parse(reader, fileName);
    }

    public Script parse(GroovyCodeSource codeSource) throws CompilationFailedException {
        return shell.parse(codeSource);
    }

    public Script parse(File file) throws CompilationFailedException, IOException {
        return shell.parse(file);
    }
    
    public Script parse(URL url) throws CompilationFailedException, IOException {
        URI uri = toURI(url);
        return shell.parse(uri);
    }

    private URI toURI(URL url) throws IOException {
        URI uri = null;
        try{
            uri = url.toURI();
        }catch(Exception ex){
            LOGGER.error(ex.getMessage(), ex);
            throw new IOException(ex);
        }
        return uri;
    }

    public Script parse(URI uri) throws CompilationFailedException, IOException {
        return shell.parse(uri);
    }

    public Script parse(String scriptText) throws CompilationFailedException {
        return shell.parse(scriptText);
    }

    public Script parse(String scriptText, String fileName) throws CompilationFailedException {
        return shell.parse(scriptText, fileName);
    }

    public Script parse(Reader in) throws CompilationFailedException {
        return shell.parse(in);
    }

    public Object invokeMethod(String name, Object args) {
        return shell.invokeMethod(name, args);
    }

    public MetaClass getMetaClass() {
        return shell.getMetaClass();
    }

    public void setMetaClass(MetaClass metaClass) {
        shell.setMetaClass(metaClass);
    }
    
}
