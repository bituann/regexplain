# RegExPlain

> AI-powered agent that explains the kind of strings a regular expression matches

**regexplain** is an AI agent that takes a regular expression pattern and produces a human-friendly explanation of what kinds of strings that pattern matches. The goal is to make complex regexes more readable and maintainable.

---

## Table of Contents

- [Features](#features)
- [Motivation](#motivation)
- [Endpoints](#endpoints)
- [Dependencies](#dependencies)

---

## Features

- Parse a regular expression and break down its components (literals, quantifiers, groups, alternation, character classes, anchors, etc.)
- Provide a step-by-step explanation of how the regex processes a candidate string
- Generate example strings that *match* and *don’t match* the regex
- Optionally surface warnings or pitfalls (e.g. greedy vs lazy quantifiers, backtracking issues)
- Support for common flavors/features (depending on implementation): lookahead/lookbehind, capturing vs non-capturing groups, escapes, unicode, etc
- API interface (uses A2A protocol)

---

## Motivation

Regular expressions are powerful but can be hard to read, maintain, or audit, even more so as they grow in complexity.  
By providing a “translation” layer that can explain *what* a regex does (in human terms) and *why*, **regexplain** helps:

- Developers understand regexes written by others
- Debug or refactor regex patterns safely
- Assist in documentation and code review
- Teach or onboard developers to regex syntax and edge cases

---

## Endpoints

- ### GET (`/a2a/agent/regexplain/.well-known/agent.json`)

This endpoint returns the agent card in json format. The agent card consists of the properties that describe the agent to others.
Properties such as: name, id, url, skills etc

- ### POST (`/a2a/agent/regexplain/`)

This endpoint receives requests using the JSON convention of the A2A protocol. It then executes the agent and returns a response following the same convention

---

## Dependencies

All dependencies are included in pom.xml, and are managed by maven. Hence, the only required installations are:

- Java 17+
- Maven 3.9.11+
