# Exercise 6 – Website Comparator with Strategy Pattern

## Task 1 – Multiple Comparison Strategies

### Overview

The code from Exercise 5 (single-strategy website comparison) has been rewritten to support
**three interchangeable comparison strategies** using the **Strategy design pattern**.

### The Three Strategies

| # | Strategy class | Criterion |
|---|---------------|-----------|
| 1 | `ContentSizeStrategy` | Identical content size – compares the character length of the raw HTML responses. |
| 2 | `HtmlContentStrategy` | Identical HTML content – compares the full raw HTML strings character-by-character. |
| 3 | `TextContentStrategy` | Identical text content – strips all HTML tags, normalises whitespace, then compares the visible text. |

### How the Strategy Pattern Works Here

```
Client (WebsiteComparatorRunner)
        |
        v
WebsiteComparator   <-----  setStrategy(strategy)
        |
        | delegates compare()
        v
WebsiteComparisonStrategy  <<interface>>
   /         |         \
ContentSize  Html     TextContent
Strategy     Strategy   Strategy
        \      |      /
         WebsiteFetcher (shared HTTP helper)
```

1. **`WebsiteComparisonStrategy`** – the Strategy *interface*. Declares `compare(url1, url2)` and `getName()`.
2. **Concrete strategies** – each implements the interface with a different algorithm.
3. **`WebsiteComparator`** – the *Context*. Holds a reference to the active strategy and delegates `compare()` to it. The strategy can be replaced at runtime with `setStrategy()`.
4. **`WebsiteFetcher`** – utility class (not part of the pattern) that handles the HTTP GET request, shared by all strategies to avoid code duplication.
5. **`WebsiteComparatorRunner`** – the entry point that wires everything together and prints results.

---

## Task 2 – UML Diagram

The UML class diagram is in `strategy_uml.puml` (PlantUML format).

Key relationships shown:

- `WebsiteComparisonStrategy` ← `ContentSizeStrategy`, `HtmlContentStrategy`, `TextContentStrategy`
  (realisation, `<|..`)
- `WebsiteComparator` ◇→ `WebsiteComparisonStrategy`
  (aggregation – the context *holds* a strategy, `o-->`)
- All three concrete strategies → `WebsiteFetcher`
  (dependency – they call the static `fetchHtml()` method, `..>`)
- `WebsiteComparatorRunner` → `WebsiteComparator`
  (dependency – creates and drives the context)

---

## Task 3 – Coding Conventions

### Naming

| Element | Convention | Example |
|---------|-----------|---------|
| Class / Interface | `PascalCase` | `WebsiteComparator`, `ContentSizeStrategy` |
| Method / variable | `camelCase` | `fetchHtml()`, `url1`, `noScript` |
| Constant | `UPPER_SNAKE_CASE` | `TIMEOUT_MS`, `USER_AGENT` |
| Package | lowercase, underscored | `exercise_6` |

### Structure

- One public type per file; file name matches the type name exactly (Java convention).
- The package name mirrors the folder name (`exercise_6`).
- Each class has a single, clearly-stated responsibility (Single Responsibility Principle).

### Comments & Documentation

- Every public type and public method has a Javadoc comment (`/** … */`).
- Inline comments (`//`) are used only where the *reason* would not be obvious from the code (e.g. the regex logic in `TextContentStrategy.extractText()`).
- No commented-out dead code is left in the repository.

### Design principles applied

- **Program to interfaces** – `WebsiteComparator` references `WebsiteComparisonStrategy`, never a concrete class.
- **Open/Closed** – adding a fourth strategy requires no changes to `WebsiteComparator` or `WebsiteComparatorRunner`.
- **DRY** – HTTP fetching lives in one place (`WebsiteFetcher`).
- **No external dependencies** – only the Java standard library (`java.net`, `java.io`) is used.

### Error handling

- `IOException` is declared on `compare()` in the interface and propagated to the runner, which catches it per-strategy and prints a descriptive error message without crashing the whole comparison run.

---

## Task 4 – GitHub Commit

All files for this exercise are committed under `src/exercise_6/` in the existing repository.

Files included:

```
src/exercise_6/
├── WebsiteComparisonStrategy.java   # Strategy interface
├── ContentSizeStrategy.java         # Strategy 1
├── HtmlContentStrategy.java         # Strategy 2
├── TextContentStrategy.java         # Strategy 3
├── WebsiteFetcher.java              # Shared HTTP utility
├── WebsiteComparator.java           # Context class
├── WebsiteComparatorRunner.java     # Main entry point
├── strategy_uml.puml                # UML class diagram
└── WORKSHEET.md                     # This documentation
```
